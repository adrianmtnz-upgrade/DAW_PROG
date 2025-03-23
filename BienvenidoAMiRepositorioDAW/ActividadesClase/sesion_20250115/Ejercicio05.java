package ActividadesClase.sesion_20250115;


public class Ejercicio05 {
    /*
     * Sumatoria de números
     * Escribe una función recursiva que calcule la suma de los números del 1 al ( n ).
     * Ejemplo: suma(5) = 1 + 2 + 3 + 4 + 5 = 15.
     */

     public static void main(String[] args) {
        System.out.println("El termino 12 de la sucesión de Fibonacci es: " + fibonacci(12));
     }

     public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
     }
}
