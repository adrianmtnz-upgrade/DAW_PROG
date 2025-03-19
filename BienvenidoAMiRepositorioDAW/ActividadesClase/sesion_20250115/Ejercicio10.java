package sesion_20250115;

public class Ejercicio10 {
    // Torre de Hanói
    // Implementa la solución al problema clásico de la Torre de Hanói para ( n ) discos.

    public static void main(String[] args) {
        resolverTorres(3, 'A', 'B', 'C');
    }
    
    public static void resolverTorres(int n, char origen, char auxiliar, char destino){
        if(n==1){
            System.out.println("Mover disco 1 de " +origen+ " a "+destino);
            return;
        }
        resolverTorres(n-1, origen, destino, auxiliar);
        System.out.println("Mover disco "+n+" de "+origen+" a "+destino);
        resolverTorres(n-1, auxiliar, origen, destino);
    }
}
