package ActividadesClase.sesion_20250115;


public class Ejercicio07 {
    /*
     * Sumar dígitos de un número
     * Escribe una función recursiva que sume los dígitos de un número.
     * Ejemplo: sumaDigitos(123) = 1 + 2 + 3 = 6.
     */
    public static void main(String[] args) {
        System.out.println(sumaDigitos(123));
    }

    public static int sumaDigitos(int n) {
        if (n < 10) return n;
        return n % 10 + sumaDigitos(n / 10);
    }
}
