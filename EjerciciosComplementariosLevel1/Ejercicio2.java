import java.util.Scanner;

public class Ejercicio2 {

    private static final Scanner SCANNER = new Scanner( System.in );
    public static void main( String[] args ) {
        Scanner Operation = SCANNER;
        int Num1, Num2;

        System.out.println("Ingrese el primer numero: "); 
        Num1 = Operation.nextInt();

        System.out.println("Ingrese el sugundo numero: "); 
        Num2 = Operation.nextInt();

        System.out.println(Num1 + " + " + Num2 + " = " + (Num1+Num2));
        System.out.println(Num1 + " - " + Num2 + " = " + (Num1-Num2));
        System.out.println(Num1 + " * " + Num2 + " = " + (Num1*Num2));
        System.out.println(Num1 + " / " + Num2 + " = " + (Num1/Num2));
        System.out.println(Num1 + " % " + Num2 + " = " + (Num1%Num2));

    }
}
