import java.util.Scanner;

public class Ejercicio3 {
    private static final Scanner SCANNER = new Scanner( System.in );
    public static void main( String[] args ) {
        Scanner Operation = SCANNER;
        int num;

        System.out.println("Ingrese el numero: "); 
        num = Operation.nextInt();
    
        for (int i = 1; i <= num; i++) {
          for (int j = 1; j <= i ; j++) {
            System.out.print(j + " ");
          }
          System.out.println("");
        }

    }
}
