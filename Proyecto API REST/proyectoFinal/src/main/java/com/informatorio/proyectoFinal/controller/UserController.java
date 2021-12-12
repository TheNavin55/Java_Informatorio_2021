package com.informatorio.proyectoFinal.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.informatorio.proyectoFinal.DAO.UsersDAO;
import com.informatorio.proyectoFinal.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UsersDAO usersDAO;

    
    public ResponseEntity<List<User>> getUser(){
        List<User> users = usersDAO.findAll();
        return ResponseEntity.ok(users);
    }
    @RequestMapping(value="{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId){
        Optional<User> userById = usersDAO.findById(userId);
        if(userById.isPresent()){
            return ResponseEntity.ok(userById.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = usersDAO.save(user);
        return ResponseEntity.ok(newUser);
    }
    @DeleteMapping(value="{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId){
        usersDAO.deleteById(userId);
        return ResponseEntity.ok(null);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        Optional<User> updateUser = usersDAO.findById(user.getId());
        if(updateUser.isPresent()){
            User userUpdate = updateUser.get();
            userUpdate.setUserName(user.getUserName());
            userUpdate.setApellido(user.getApellido());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(user.getPassword());
            userUpdate.setCreatedDate(user.getCreatedDate());
            userUpdate.setCity(user.getCity());
            userUpdate.setProvince(user.getProvince());
            userUpdate.setCountry(user.getCountry());
            userUpdate.setUserType(user.getUserType());
            usersDAO.save(userUpdate);
            return ResponseEntity.ok(userUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(
            @RequestParam(name = "createdDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate createdDate,
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "city", required = false) String city){
                if(createdDate != null){
                    return new ResponseEntity<>(usersDAO.findByCreatedDateAfter(createdDate.atStartOfDay()), HttpStatus.OK);
                } else if (Objects.nonNull(username)) {
                    return new ResponseEntity<>(usersDAO.findByUsername(username), HttpStatus.OK);
                } else if (Objects.nonNull(city)){
                    return new ResponseEntity<>(usersDAO.findByCity(city), HttpStatus.OK);
                }
                return new ResponseEntity<>(usersDAO.findAll(), HttpStatus.OK);
    }
    
}
