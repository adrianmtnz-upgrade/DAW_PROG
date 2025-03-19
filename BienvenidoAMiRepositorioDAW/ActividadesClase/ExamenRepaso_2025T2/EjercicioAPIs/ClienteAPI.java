

public class ClienteAPI {
    private API api;

    public ClienteAPI(API api){
        this.api=api;
    }

    public API getAPI(){
        return api;
    }

    public void setAPI(API api){
        this.api=api;
    }

    public void mostrarDatos(){
        System.out.println("Los datos obtenidos son: "+api.obtenerDatos());
    }
}
