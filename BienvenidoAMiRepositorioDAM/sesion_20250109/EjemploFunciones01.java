package sesion_20250109;

public class EjemploFunciones01 {
    public static void main(String[] args) {
        // Voy a crear una función que me permita elevar un número 'a' a la potencia 'b'.
        // La idea es que mas adelante esta siguiente linea funcione:
        double resultado = potencia(2.8, 3.3);
        System.out.println("El resultado de 2.8^3.3 es: " + resultado);
    }

    public static double potencia(double a, double b) {
        double resultado = Math.pow(a, b);
        return resultado;
    }
}