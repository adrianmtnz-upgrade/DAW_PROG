package TestingNewThings.lambdaExpressions.vehiclesList;

public class Vehicle {

    private String matricle;
    private Brand brand;
    private String model;
    private int km;
    
    public Vehicle(String matricle, Brand brand, String model, int km) {
        this.matricle = matricle;
        this.brand = brand;
        this.model = model;
        this.km = km;
    }

    public String getMatricle() {
        return matricle;
    }
    
    public void setMatricle(String matricle) {
        this.matricle = matricle;
    }
    
    public Brand getBrand() {
        return brand;
    }
    
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getKm() {
        return km;
    }
    
    public void setKm(int km) {
        this.km = km;
    }
    
    @Override
    public String toString() {
        return "| Matricle: " + matricle + " | Brand: " + brand + " | Model: " + model + " | km: " + km +" |";
    }

}

