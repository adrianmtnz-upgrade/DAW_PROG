package ActividadesClase.sesion_20250326;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterate {
    public static void main(String[] args) {
    
        // Create a list
        ArrayList<String> myAlumnsList = new ArrayList<>();
        
        //Insert 6 different names on the list
        myAlumnsList.add("Juan");
        myAlumnsList.add("Pedro");
        myAlumnsList.add("Ana");
        myAlumnsList.add("Maria");
        myAlumnsList.add("Luis");
        myAlumnsList.add("Jose");
        
        // Iterate using Iterator
        System.out.println("1. Iterator");
        Iterator<String> myListIterator = myAlumnsList.iterator();
        while (myListIterator.hasNext()) {
            System.out.println(myListIterator.next());
        }
    
        // Iterate using for loop
        System.out.println("2. For loop");
        for (int i = 0; i < myAlumnsList.size(); i++) {
            System.out.println(myAlumnsList.get(i));
        }

        // Iterate using for-each loop
        System.out.println("3. For-each loop");
        for (String name : myAlumnsList) {
            System.out.println(name);
        }

        // Iterate using while loop
        System.out.println("4. While loop");
        int i = 0;
        while (i < myAlumnsList.size()) {
            System.out.println(myAlumnsList.get(i));
            i++;
        }
    }
}
