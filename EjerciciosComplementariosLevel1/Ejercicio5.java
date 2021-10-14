import java.util.Scanner;

public class Ejercicio5 {

    private static final Scanner SCANNER = new Scanner( System.in );
    public static void main( String[] args ) {
        Scanner Operation = SCANNER;
        int suma=0;

        System.out.println("ingrese primer numero:");
        int a=Operation.nextInt();
        
        System.out.println("ingrese segundo numero:");
        int b=Operation.nextInt();

        for (int i = 1; i<= b; i++){
            suma=suma + a;

        }
        System.out.println("el producto es: " + suma);
    
    }

}
