import java.util.Scanner;

public class Ejercicio1 {

    /**
     *
     */
    private static final Scanner SCANNER = new Scanner( System.in );

    public static void main(String[] args) {
        Scanner Nombre = SCANNER;
        String Usuario;

        System.out.println("Ingrese el nombre de usuario: ");
        Usuario = Nombre.nextLine();

        System.out.println("HOLA " + Usuario); 
    }
}