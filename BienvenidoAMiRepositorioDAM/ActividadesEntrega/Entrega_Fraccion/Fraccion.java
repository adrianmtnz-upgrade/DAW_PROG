package ActividadesEntrega.Entrega_Fraccion;
import java.util.Scanner;

/**
 * La clase Fraccion representa una fracción matemática con un numerador y un denominador.
 * Proporciona métodos para inicializar, obtener y establecer los valores del numerador y denominador,
 * así como para calcular el resultado de la fracción y convertirla a una representación en cadena.
 *
 * @author Adrian Martinez Palazon
 * @version 1.0
 */
public class Fraccion {
    
    /**
     * El numerador de la fracción.
     * 
     * Los atributos numerador y denominador son privados para que no se puedan modificar desde fuera de la clase. 
     * 
     * Ademas, esto permite que para modificarlos dentro de la clase se haga a traves de metodos get y set que filtran
     * los valores que se le pasan.
     */
    private double numerador;
    
    /**
     * El denominador de la fracción.
     */
    private double denominador;

    /**
     * Constructor por defecto que inicializa la fracción a 0/1.
     */
    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    /**
     * Constructor que inicializa la fracción con el numerador y denominador dados.
     * Si el denominador es 0, lo establece a 1 y muestra un mensaje de advertencia.
     *
     * @param numerador   El numerador de la fracción.
     * @param denominador El denominador de la fracción.
     */
    public Fraccion(double numerador, double denominador) {
        this.numerador = numerador;
        if (denominador != 0) {
            this.denominador = denominador;
        } else {
            System.out.println("El denominador no puede ser 0. Se establecerá a 1 por defecto.");
            this.denominador = 1;
        }
    }

    /**
     * Constructor que inicializa la fracción con el numerador dado y establece el denominador a 1.
     *
     * @param numerador El numerador de la fracción.
     */
    public Fraccion(double numerador) {
        this.numerador = numerador;
        this.denominador = 1;
    }

    /**
     * Devuelve el numerador de la fracción.
     *
     * @return El numerador de la fracción.
     */
    public double getNumerador() {
        return numerador;
    }

    /**
     * Devuelve el denominador de la fracción.
     * 
     * el denominador no puede ser cero porque ha sido filtrado en el metodo setDenominador
     *
     * @return El denominador de la fracción.
     */
    public double getDenominador() {
        return denominador;
    }

    /**
     * Establece el numerador de la fracción.
     *
     * @param numerador El nuevo numerador de la fracción.
     */
    public void setNumerador(double numerador) {
        this.numerador = numerador;
    }

    /**
     * Establece el denominador de la fracción. Si el denominador es 0, muestra un mensaje de advertencia.
     *
     * @param denominador El nuevo denominador de la fracción.
     */
    public void setDenominador(double denominador) {
        if (denominador != 0) {
            this.denominador = denominador;
        } else {
            System.out.println("El denominador no puede ser 0.");
        }
    }

    /**
     * Convierte la fracción a una representación en cadena.
     * Si tanto el numerador como el denominador son enteros, los devuelve como enteros.
     *
     * @return La representación en cadena de la fracción.
     */
    public String convertirAString() {
        if (numerador % 1 == 0 && denominador % 1 == 0) {
            return String.valueOf((int) numerador) + "/" + String.valueOf((int) denominador);
        }
        return String.valueOf(numerador) + "/" + String.valueOf(denominador);
    }

    /**
     * Calcula el resultado de la fracción como un doble redondeado a dos decimales.
     *
     * @return El resultado de la fracción redondeado a 2 decimales.
     */
    public double calcularResultado() {
        return (Math.round(100 * (numerador / denominador)) / 100.0);
    }

    /**
     * Interactúa con el usuario para realizar operaciones con fracciones.
     * Proporciona opciones para calcular el resultado de una fracción o salir del programa.
     */
    public static void interaccionPrograma() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el numero de opcion que deseas realizar:");
        System.out.println("1. Calcular resultado");
        System.out.println("2. Salir");

        int opcion = entrada.nextInt();
        if (opcion == 1) {
            interaccionCalcularResultado(entrada);

        } else if (opcion == 2) {
            return;
        } else {
            System.out.println("Opcion no valida");
            interaccionPrograma();
        }
        entrada.close();
    }

    /**
     * Interactúa con el usuario para calcular el resultado de una fracción.
     * Solicita al usuario que ingrese el numerador y el denominador, luego calcula y muestra el resultado.
     *
     * @param entrada El objeto Scanner para la entrada del usuario.
     */
    public static void interaccionCalcularResultado(Scanner entrada) {
        System.out.println("Introduce el numerador: ");
        Fraccion fraccion1 = new Fraccion();
        fraccion1.setNumerador(entrada.nextDouble());
        
        System.out.println("Introduce el denominador: ");
        fraccion1.setDenominador(entrada.nextDouble());
        
        double resultado = fraccion1.calcularResultado();
        System.out.println("El resultado de la fraccion " + fraccion1.convertirAString() + " es: " + resultado);
        System.out.println("Quieres hacer otra operacion? (SI/NO)");
        
        String continuar = entrada.next().toUpperCase();
        if (continuar.equals("SI")) interaccionPrograma();
    }

    /**
     * El método principal que inicia el programa de la calculadora de fracciones.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("CALCULADORA DE FRACCIONES");
        System.out.println("----------------------------");
        interaccionPrograma();
        System.out.println("Gracias por utilizar el programa, hasta luego!");
        System.out.println("CERRANDO...");
    }
}
