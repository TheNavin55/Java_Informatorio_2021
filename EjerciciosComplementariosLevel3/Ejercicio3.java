import java.util.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<String> palabras = List.of("Batman", "Aquaman", "Flash", "Batgirl", "Wonder Woman", "brainiac");

        long filtro = palabras.stream()
                                .filter(p -> p.startsWith("B") || p.startsWith("b"))
                                .count();
        
        System.out.print(filtro);

    }
    
}
