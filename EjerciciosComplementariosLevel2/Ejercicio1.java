import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

    private static final Scanner SCANNER = new Scanner( System.in );

    public static void main(String[] args) {
        Scanner Nombre = SCANNER;
        List<String> Ciudades = new ArrayList<>();
        String Ciudad = "0";
        int i = 0;
        

        while (!Ciudad.equals("n")){
            System.out.println("Ingrese sus ciudades favoritas. Para finalizar ingrese: n");
            Ciudad = Nombre.nextLine();

            i = i+1;

            Ciudades.add(Ciudad);

        }

        Formato(Ciudades,i);

    }
        
    public static void Formato(List<String> s, int d){


        for (int i = 0 ; i < d ; i++){
            String ciudad = s.get(i);

            if(!ciudad.equals("n")){

                System.out.println("#"+(i+1)+" - "+ciudad);

            }

        }


    }

}