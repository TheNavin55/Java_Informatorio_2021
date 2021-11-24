import java.util.*;
import java.util.stream.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<Integer> palabras = List.of(1, 2, 4, 4, 4);
        List<Integer> palabrasV2 = palabras.stream()
                                .map(x -> Ejercicio4.factorial(x))
                                .distinct()
                                .collect(Collectors.toList());
        System.out.print(palabrasV2);
    }

    public static Integer factorial(Integer num){
        int resultado = 1;
        for( int i = num; i > 0; i--){
            resultado = resultado*i;
        }
        return resultado;
    }
    
}
