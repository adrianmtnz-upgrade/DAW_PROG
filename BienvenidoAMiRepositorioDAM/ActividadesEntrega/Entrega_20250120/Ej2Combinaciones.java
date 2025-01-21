package ActividadesEntrega.Entrega_20250120;
import java.util.Scanner;


public class Ej2Combinaciones {
    /* 
     * Escribe un programa que calcule las combinaciones posibles de n elementos 
     * tomados de k en k utilizando recursividad. Una combinación es un subconjunto 
     * de tamaño k extraído de un conjunto den elementos*
     *
     * 1. El usuario debe ingresar n (el tamaño del conjunto) y k (el tamaño del subconjunto).
     * 2. Usa recursividad para calcular el número total de combinaciones.
     * 3. Muestra el número total de combinaciones posibles.
     */
        public static final String VERDE = "\u001B[32m";
        public static final String AZUL = "\u001B[36m";
        public static final String MORADO = "\u001B[35m";
        public static final String AMARILLO = "\u001B[33m";
        public static final String RESET = "\u001B[0m";
    public static void main(String[] args) {
        System.out.println(MORADO+"CALCULADORA DE COMBINACIONES" + RESET + "\n");
        interaccionUsuario();
    }

    public static void interaccionUsuario() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println(AZUL+"Introduce el tamaño total del conjunto: "+ VERDE);
        int n = entrada.nextInt();
        entrada.nextLine(); 
        System.out.println(AZUL+"Introduce el tamaño del subconjunto: "+VERDE);
        int k = entrada.nextInt();
        entrada.nextLine();
        
        System.out.println(AZUL+"El número total de combinaciones posibles es: "+MORADO+calcularCombinaciones(n, k));
        
        System.out.println(AMARILLO+"Quieres hacer otra operación?"+VERDE);
        String continuar = entrada.nextLine().toUpperCase();
        if (continuar.equals("SI")) {
            interaccionUsuario();
        } else {
            System.out.println(MORADO+"Hasta luego! \n CERRANDO PROGRAMA...");
        } entrada.close();
    }

    public static int calcularCombinaciones(int n, int k) {
        return (k==0 || k==n)? 1 : calcularCombinaciones(n-1, k-1) + calcularCombinaciones(n-1, k);
    }
}
