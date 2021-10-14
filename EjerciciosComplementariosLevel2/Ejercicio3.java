import java.util.*;

public class Ejercicio3 {
	public static void main (String[] args) {
         Set<Integer>Order = new LinkedHashSet<Integer>();
         Order.add(1);
         Order.add(2);
         Order.add(3);
         Order.add(4);
         Order.add(5);
         Order.add(6);
         Order.add(7);
         Order.add(8);
         Order.add(9);
         Order.add(10);
         Order.add(11);
         Order.add(12);
         Order.add(13);
         System.out.println("Set original: " + Order);
         List<Integer> shuffleMe = new ArrayList<Integer>(Order);
         Collections.shuffle(shuffleMe);
         Set<Integer> shuffledSet = new LinkedHashSet<Integer>();
         shuffledSet.addAll(shuffleMe);
         System.out.println("Set desordenado : " +  shuffledSet);
	}
}