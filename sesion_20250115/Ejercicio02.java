package sesion_20250115;

public class Ejercicio02 {
    /* 
     * Sumatoria de números
     * Escribe una función recursiva que calcule la suma de los números del 1 al ( n ).
     * Ejemplo: suma(5) = 1 + 2 + 3 + 4 + 5 = 15.
     */

    public static void main(String[] args) {
        int numero = 5;
        System.out.println("La suma de los números del 1 al " + numero + " es: " + sumatoria(numero));
    }

    public static int sumatoria(int n) {
        if (n < 0) return -1;
        if (n == 0 )return 0;
        return sumatoria(n - 1);
    }
}
