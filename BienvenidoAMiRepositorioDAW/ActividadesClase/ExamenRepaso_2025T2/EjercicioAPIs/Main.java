package ActividadesClase.ExamenRepaso_2025T2.EjercicioAPIs;

public class Main {
    public static void main(String[] args){
        
        ClienteAPI cliente01 = new ClienteAPI(new ApiGitHub());
        
        cliente01.mostrarDatos();

        cliente01.setAPI(new ApiClima());
        cliente01.mostrarDatos();
    }
}
