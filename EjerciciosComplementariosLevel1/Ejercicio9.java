import java.util.Scanner;

public class Ejercicio9 {

    private static final Scanner SCANNER = new Scanner( System.in );

    public static void main( String[] args ){
        Scanner string = SCANNER;
        String str, word;

        System.out.println("Ingrese la palabra: "); 
        str = string.nextLine();
        
        System.out.println("Ingrese la letra: "); 
        word = string.nextLine();

        str = str.toLowerCase();
        char palabra = word.charAt(0);
        
        lettersCount(str, palabra);
        
    }

    public static void lettersCount(String s, char d) {

        String frase = s;

        int total = 0;
        char temp;
        for (int i = 0; i < frase.length(); i++) {

            temp = frase.charAt(i);
            if (temp == d)
                total++;
        }

        System.out.println("La letra "+d+" aparece "+total+" veces.");
    }
}
