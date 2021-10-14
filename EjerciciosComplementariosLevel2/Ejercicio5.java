import java.util.*;

public class Ejercicio5{
	public static void main (String[] args) {
        List<Integer> horas = new ArrayList<Integer>();
        List<Integer> precioh = new ArrayList<Integer>();
        int total=0;
        precioh.add(350);    
        precioh.add(345);    
        precioh.add(550);    
        precioh.add(600);    
        precioh.add(320);
        
        horas.add(6);
        horas.add(7);
        horas.add(8);
        horas.add(4);
        horas.add(5);
        
        System.out.print("[ ");

        for(int i=0;i<=4;i++){
            int resultado = horas.get(i) * precioh.get(i);
            System.out.print(resultado+" ");
            total +=resultado;
        }
		System.out.println("]");
		System.out.print("El total es: "+ total);

    }
}