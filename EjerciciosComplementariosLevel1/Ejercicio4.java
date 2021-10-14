import java.util.Scanner;

public class Ejercicio4 {
    private static final Scanner SCANNER = new Scanner( System.in );
    public static void main( String[] args ) {
        Scanner Operation = SCANNER;
        int num;

        System.out.println("Ingrese el numero: "); 
        num = Operation.nextInt();

        System.out.println("El factorial de " + num + " es " + factorial(num));
    
    }
    
    public static Integer factorial(Integer num){
        int resultado = 1;

        for( int i = num; i > 0; i--){

            resultado = resultado*i;

        }

        return resultado;
    }
    
}
