package ActividadesClase.Examen_2024T1;

import java.util.Scanner;

public class Matrices {
    public static void main (String[] args){
        System.out.println(
            "--------  MATRICES CUADRADAS  -------- \n\n"
            
            
            );

        Scanner user = new Scanner(System.in);
        int rangoMatriz = user.nextInt();
        
        int[][] matrizCuadrada = new int[rangoMatriz][rangoMatriz];
        
        int contador = 1;
        
        for(int fila = 0; fila < matrizCuadrada.length; fila++){
            for(int columna = 0; columna < matrizCuadrada[fila].length; columna++){
                matrizCuadrada[fila][columna] = contador;
                contador++;
            }
        }

        System.out.println("\nLa matriz es:\n");
        for(int[] fila : matrizCuadrada){
            for(int columna : fila){
                System.out.print(columna + "\t");
            }
            System.out.println("\n");
        }

        user.close();
            
        int contarFila = 1;
        for(int[] fila : matrizCuadrada){
            int sumaFila = 0;
            for(int columna : fila){
                sumaFila += columna;
            }
            System.out.println("La suma de la fila "+ contarFila+ " es: " + sumaFila);
            contarFila++;
        }
            
        int contarColumna = 1;
        for (int columna = 0; columna < matrizCuadrada[rangoMatriz].length; columna++) {
            int sumaColumna = 0;
            for (int fila = 0; fila < matrizCuadrada.length; fila++) {
                sumaColumna += matrizCuadrada[fila][columna];
            }
            System.out.println("La suma de la columna " + contarColumna + " es: " + sumaColumna);
            contarColumna++;
        }


    }
}
