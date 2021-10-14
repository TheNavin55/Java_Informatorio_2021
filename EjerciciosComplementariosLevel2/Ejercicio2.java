import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
        public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        int length = numeros.size();

        System.out.println(numeros);
        System.out.println(length);

        numeros.add(0, 0);
        numeros.add(6, length+1);

        length = numeros.size();


        System.out.println(numeros);
        System.out.println(length);


    }
    
}
