package ActividadesEntrega.Entrega_20250427;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable{
    private double latitude;
    private double longitude;
    private String name;

    // Constructor
    public City(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Name= " + "'"+ name +"' " 
                + "Latitude= " + latitude 
                + ", Longitude= " + longitude ;
    }

    // Override equals and hashCode to ensure proper comparison of City objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return Double.compare(city.latitude, latitude) == 0 &&
               Double.compare(city.longitude, longitude) == 0 &&
               Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, name);
    }
}
