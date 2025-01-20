package sesion_20250109;

public class EjemploFuncion03 {

    // Sobrecarga de funciones
    public static void main(String[] args) {
        System.out.println(mayor(3, 5, 2));
    }
    public static int mayor(int numero1, int numero2, int numero3) {
        if (numero1 >= numero2 && numero1 >= numero3) return numero1;
        if (numero2 >= numero3 && numero2 >= numero3) return numero2;
        return numero3;
    }

    public static int mayor(int numero1, int numero2) {
        if (numero1 >= numero2) return numero1;
        return numero2;
    }
}

