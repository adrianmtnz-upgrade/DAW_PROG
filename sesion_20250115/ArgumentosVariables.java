package sesion_20250115;

public class ArgumentosVariables {
    
    public static void main(String[] args) {
        System.out.println(sumar(1,2,3));
        System.out.println(sumar(1,2,3,4));
        imprimirCaracteres();
    }

    public static int sumar(int... numeros){
        int suma = 0;
        for (int num : numeros){
            suma += num;
        }
        return suma;
    }

    public static void imprimirCaracteres() {
        String palabra = "Hola mundo";
        for (char c : palabra.toCharArray()){
            System.out.println(c);
        }
    }
}

