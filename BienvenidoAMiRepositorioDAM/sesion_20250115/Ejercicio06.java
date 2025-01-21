package sesion_20250115;

public class Ejercicio06 {
    // Invertir una cadena
    // Escribe una función recursiva que invierta una cadena de texto.
    // Ejemplo: invertir("recursivo") → "ovisrucer".
    public static void main(String[] args) {
        System.out.println(invertir("recursivo"));
    }
    public static String invertir(String palabra) {
        if (palabra.isEmpty()) return palabra;
        return invertir(palabra.substring(1))+palabra.charAt(0);
    }

}
