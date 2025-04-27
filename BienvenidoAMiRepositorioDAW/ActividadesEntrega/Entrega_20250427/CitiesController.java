package ActividadesEntrega.Entrega_20250427;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.HashMap;

public class CitiesController {
    public final String fileName = "cities.dat";
    public final String fileRelPath = Paths.get("BienvenidoAMiRepositorioDAW", "ActividadesEntrega", "Entrega_20250427", fileName).toString();

    // Open the binary file and create it if it doesn't exist
    public void openBinFile(){
        File binFile = new File(fileRelPath);

        if(!binFile.exists()) {
            try {
                binFile.createNewFile();
                System.out.println(binFile.getName() + " has been created on: " + binFile.getAbsolutePath());

            } catch (IOException ex) { ex.printStackTrace(System.out); }
        } else {
            System.out.println("Getting cities from: " + binFile.getAbsolutePath());
        }
    }
    // Read the binary file and return a HashMap of cities
    @SuppressWarnings("unchecked")
    public HashMap<City, String> readCities() {
        HashMap<City, String> citiesMap = new HashMap<>();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fileRelPath))){
            citiesMap = (HashMap<City, String>) reader.readObject();
            reader.close();
        }
        catch (EOFException ex) { System.out.println("End of file reached"); }
        catch (IOException | ClassNotFoundException IOex) { System.out.println(IOex.getMessage()); }
           
        return citiesMap;
    }

    // Save the HashMap of cities to the binary file
    public void saveCities(HashMap<City, String> citiesMap) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileRelPath));
            writer.writeObject(citiesMap);
            writer.close();

        } catch (IOException ex) { ex.printStackTrace(System.out); }
    }

    // Add a city to the HashMap and save it to the binary file
    public void addCity(double latitude, double longitude, String cityName, String country) {
        try {
            HashMap<City, String> modifiedMap = readCities();
            City city = new City(latitude, longitude, cityName);

            if (modifiedMap.containsKey(city)) {
                System.out.println("City already exists at these coordinates: "+ city.getLatitude() + ", " + city.getLongitude());
                return;
            }

            modifiedMap.put(city, country);
            saveCities(modifiedMap);
            System.out.println("\nCity saved in map file successfully");

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Delete a city from the HashMap and save it to the binary file
    public void deleteCity(double latitude, double longitude, String cityName) {
        try {
            HashMap<City, String> map = readCities();
            City city = new City(latitude, longitude, cityName);
            if (map.containsKey(city)) {
                map.remove(city);

                saveCities(map);
                System.out.println("\n" + "City at lat: "+latitude+", long: "+longitude+" deleted successfully");
            } else {
                System.out.println("City not found in the map file");
            }

        } catch (Exception ex) { System.out.println(ex.getMessage()); }
    }

    // Show all cities in the HashMap
    public void showCities() {
        try {
            HashMap<City, String> map = readCities();
            if (map.isEmpty()) {
                System.out.println("No cities found in the map file");
                return;
            }

            for (City city : map.keySet()) {
                System.out.println(
                    "\nCity: \n"
                    + "{\n"
                    +city.toString() 
                    + "\nCountry: " + map.get(city)
                    + "\n}");
                System.out.println();
            }
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
    }

    // Search for a city in the HashMap and display its details
    public void searchCity(double latitude, double longitude, String cityName) {
        try {
            HashMap<City, String> map = readCities();
            City city = new City(latitude, longitude, cityName);
            if (map.containsKey(city)) {
                System.out.println("City found: " + city.toString() + "\nCountry: " + map.get(city) + "\n");
            } else {
                System.out.println("City not found in the map file");
            }
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
    }
}
