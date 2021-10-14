import java.util.*;

public class Ejercicio7 {

    private static final Scanner SCANNER = new Scanner( System.in );

    public static void main(String[] args) {
        Scanner nombre = SCANNER;
        int numero1 = 0;
        int numero2 = 0;
        
        System.out.println("Ingrese el primer numero: ");
        numero1 = nombre.nextInt();

        System.out.println("Ingrese el segundo numero: ");
        numero2 = nombre.nextInt();

        System.out.println(fizzBuzzFuncion(numero1,numero2));
    }
    
    public static List<String> fizzBuzzFuncion(int x, int y){
        List<String> cadena = new ArrayList<>();
        for (int i=x; i<y; i++){
            if (i%2==0 && i%3==0){
                cadena.add("FizzBuzz");
            } else if (i%2==0){
                cadena.add("Fizz");
                } else if (i%3==0) {
                    cadena.add("Buzz");
                    } else {
                        cadena.add(String.valueOf(i));
                    }
        }
        return cadena;
    }
        
}
