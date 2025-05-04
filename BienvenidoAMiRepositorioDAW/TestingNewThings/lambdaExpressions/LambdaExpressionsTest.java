package TestingNewThings.lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LambdaExpressionsTest {

    public static void main(String[] args) {
        
        // Imperative (Print list on traditional way)

       /* 
        *   for(Integer number : Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)){
        *       System.out.println(number);
        *   };  
        */
        
        // Declarative (Print list using lambda expressions)

        Arrays.asList(1, 2 ,3 , 4, 5, 6, 7, 8, 9, 10).forEach(n -> System.out.println(n));
        System.out.println();

        // :: operator (methods reference)
        // Direct call to the method without needing to instantiate an object
        //
        // Class::method

        Arrays.asList("A", "B", "C", "D").forEach(System.out::println);
        System.out.println();


        // ------------------------------------------------------------------------------- //

        // Imperative
        // Filters the numbers greater than 5 and adds it to a list

        /*   ArrayList<Integer> shortedList = new ArrayList<>();
         *   for(Integer number: Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) {
         *      if(number > 5) shortedList.add(number);
         *   }
         *
         *   for(Integer value : shortedList) {
         *      System.out.println(value);
         *   } 
         */

         // Lambdas

        ArrayList<Integer> filteredNumbers = (ArrayList<Integer>) Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().filter(
            x -> x > 5).collect(Collectors.toCollection(()-> new ArrayList<Integer>()));

            // .stream() opens a sequential stream over the elements of te collection
            // .filer() applys te condition between brackets to every element on the list and return the ones that matches with the filter
            // .collect() catches the elements from the filter of the stream and with the method Collectors.toCollection() turns into a new collection
            // .collect(Collectors.toList()) could be used also turning it to a List

        filteredNumbers.forEach(e -> System.out.println(e));
        
        // This may be useful for preprocessing data before sending it to the server
    }

}
