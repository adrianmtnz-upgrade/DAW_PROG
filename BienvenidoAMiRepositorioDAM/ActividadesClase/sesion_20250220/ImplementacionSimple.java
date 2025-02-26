package sesion_20250220;

interface Sonido {
    void hacerSonido();
}

interface Subir {
    void subirArbol();
}

class Gato implements Sonido, Subir {
    public void hacerSonido() {
        System.out.print("maulla");
    }
    public void subirArbol(){
        System.out.println("sube arboles.");
    }
}

class Perro implements Sonido {
    public void hacerSonido(){
        System.out.println("ladra");
    }
}


public class ImplementacionSimple {
    public static void main(String[] args){
        Sonido garfield = new Gato();
        Sonido patan = new Perro(); 
        System.out.print("Garfield ");
        garfield.hacerSonido();
        if (garfield instanceof Subir) {
            System.out.print(" y ");
            ((Subir) garfield).subirArbol();
        }
        System.out.print("Patan de vez en cuando ");
        patan.hacerSonido();
    }
}
