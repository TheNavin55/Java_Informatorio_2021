import java.util.*;

public class Ejercicio4{
	public static void main (String[] args) {
    List<String> estudiantes = new ArrayList<String>();
	estudiantes.add("pepe1");    
	estudiantes.add("pepe2");    
	estudiantes.add("pepe3");    
	estudiantes.add("pepe4");    
	estudiantes.add("pepe5");    
	estudiantes.add("pepe6");    
	estudiantes.add("pepe7");    
	estudiantes.add("pepe8");    
	estudiantes.add("pepe9");    
	estudiantes.add("pepe10");    
	estudiantes.add("pepe11");    
	estudiantes.add("pepe12");
    List<String> head = estudiantes.subList(0, 4);
    List<String> mid = estudiantes.subList(4, 8);
    List<String> tail = estudiantes.subList(8, 12);
    System.out.println(head);
    System.out.println(mid);
    System.out.println(tail);
    }
}