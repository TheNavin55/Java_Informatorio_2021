import java.util.Scanner;

public class Ejercicio7 {

    private static final Scanner SCANNER = new Scanner( System.in );

    public static void main( String[] args ) {
        Scanner string = SCANNER;
        String mayus;

        System.out.println("Ingrese la frase o palabra: "); 
        mayus = string.nextLine();

        changeCase(mayus);
    }

    public static void changeCase(String s){
        int i;

        for(i = 0; i < s.length(); i++){

            int ch=s.charAt(i);
            if(ch>64&&ch<91){

                ch=ch+32;
                System.out.print( (char) ch);
            }

            else if(ch>96&&ch<123){

                ch=ch-32;
                System.out.print( (char) ch);
            }

            if(ch==32)
            System.out.print(" ");
        }
    } 
}
