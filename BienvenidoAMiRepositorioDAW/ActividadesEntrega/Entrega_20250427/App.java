package ActividadesEntrega.Entrega_20250427;

import java.util.Scanner;

public class App {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CitiesController controller = new CitiesController();
        controller.openBinFile();

        boolean exit = false;

        while (!exit) {
            System.out.println(CYAN + "\n===== CITY MANAGEMENT MENU =====" + RESET);
            System.out.println(YELLOW + "1. Add a city");
            System.out.println("2. Show all cities");
            System.out.println("3. Search for a city");
            System.out.println("4. Delete a city");
            System.out.println("5. Exit" + RESET);
            System.out.print(BLUE + "Choose an option: " + RESET);
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // Add city
                    try {
                        System.out.print("City name: ");
                        String name = scanner.nextLine();

                        System.out.print("Country: ");
                        String country = scanner.nextLine();

                        System.out.print("Latitude: ");
                        double latitude = Double.parseDouble(scanner.nextLine());

                        System.out.print("Longitude: ");
                        double longitude = Double.parseDouble(scanner.nextLine());

                        controller.addCity(latitude, longitude, name, country);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Latitude and longitude must be valid numbers." + RESET);
                    }
                    break;

                case "2": // Show all cities
                    System.out.println(CYAN + "\nList of cities:" + RESET);
                    controller.showCities();
                    break;

                case "3": // Search for a city
                    try {
                        System.out.print("City name to search: ");
                        String name = scanner.nextLine();

                        System.out.print("Latitude: ");
                        double lat = Double.parseDouble(scanner.nextLine());

                        System.out.print("Longitude: ");
                        double lon = Double.parseDouble(scanner.nextLine());

                        controller.searchCity(lat, lon, name);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Latitude and longitude must be valid numbers." + RESET);
                    }
                    break;

                case "4": // Delete city
                    try {
                        System.out.print("City name to delete: ");
                        String name = scanner.nextLine();

                        System.out.print("Latitude: ");
                        double lat = Double.parseDouble(scanner.nextLine());

                        System.out.print("Longitude: ");
                        double lon = Double.parseDouble(scanner.nextLine());

                        controller.deleteCity(lat, lon, name);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Latitude and longitude must be valid numbers." + RESET);
                    }
                    break;

                case "5": // Exit
                    System.out.println(YELLOW + "Exiting the program..." + RESET);
                    exit = true;
                    break;

                default:
                    System.out.println(RED + "Invalid option. Please try again." + RESET);
            }
        }

        scanner.close();
    }
}