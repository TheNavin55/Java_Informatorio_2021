import java.util.Scanner;
import java.util.Formatter;

public class Ejercicio8 {
    
    private static final Scanner SCANNER = new Scanner( System.in );

    public static void main( String[] args ) {
        Scanner string = SCANNER;
        String Ciudad, Direccion, Edad, Nombre_Apellido;

        System.out.println("Ingrese Nombre y Apellido: "); 
        Nombre_Apellido = string.nextLine();

        System.out.println("Ingrese la Edad: "); 
        Edad = string.nextLine();

        System.out.println("Ingrese la Dirección: "); 
        Direccion = string.nextLine();

        System.out.println("Ingrese la Ciudad: "); 
        Ciudad = string.nextLine();

        Formatter formatter = new Formatter();

        Object cadenaFormato = formatter.format("{   %-7s} - {   %-9s} - {   %-7s} - {   %-19s}", Ciudad, Direccion, Edad, Nombre_Apellido);
        System.out.println("{  Ciudad  } - { Direccion  } - {   Edad   } - {  Nombre y Apellido   }");                                   
        
        System.out.println(cadenaFormato);

    }
    
}
