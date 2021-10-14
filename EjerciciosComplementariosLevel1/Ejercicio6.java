import java.util.Scanner;

public class Ejercicio6 {

    private static final Scanner SCANNER = new Scanner( System.in );
    public static void main( String[] args ) {
        Scanner Operation = SCANNER;
        int potencia=1;

        System.out.println("ingrese primer numero:");
        int a=Operation.nextInt();
        
        System.out.println("ingrese segundo numero:");
        int b=Operation.nextInt();

        for (int i = 1; i<= b; i++){
            potencia=potencia * a;

        }
        System.out.println("el producto es: " + potencia);
    
    }

}