package TestingNewThings.lambdaExpressions.vehiclesList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class VehiclesApp {
    public static void main(String[] args) {
        List<Vehicle> vehiclesList = new ArrayList<>();

        vehiclesList.add(new Vehicle("1234ABC", Brand.TOYOTA, "Corolla", 55000));
        vehiclesList.add(new Vehicle("5678DEF", Brand.HONDA, "Civic", 32000));
        vehiclesList.add(new Vehicle("9012GHI", Brand.AUDI, "A4", 7500));
        vehiclesList.add(new Vehicle("3456JKL", Brand.BMW, "320i", 61000));
        vehiclesList.add(new Vehicle("7890MNO", Brand.MERCEDES, "C-Class", 47000));
        vehiclesList.add(new Vehicle("1122PQR", Brand.MAZDA, "CX-5", 3900));
        vehiclesList.add(new Vehicle("3344STU", Brand.OPEL, "Astra", 82000));
        vehiclesList.add(new Vehicle("5566VWX", Brand.CITROEN, "C3", 25000));
        vehiclesList.add(new Vehicle("7788YZA", Brand.PEUGEOT, "308", 6700));
        vehiclesList.add(new Vehicle("9900BCD", Brand.HYUNDAI, "i30", 58000));
        vehiclesList.add(new Vehicle("1357EFG", Brand.TOYOTA, "Yaris", 30000));
        vehiclesList.add(new Vehicle("2468HIJ", Brand.HONDA, "Accord", 49000));
        vehiclesList.add(new Vehicle("3690KLM", Brand.AUDI, "Q5", 7300));
        vehiclesList.add(new Vehicle("1470NOP", Brand.BMW, "X1", 52000));
        vehiclesList.add(new Vehicle("2581QRS", Brand.MERCEDES, "E-Class", 88000));
        vehiclesList.add(new Vehicle("3692TUV", Brand.MAZDA, "Mazda3", 4600));
        vehiclesList.add(new Vehicle("4813WXY", Brand.OPEL, "Insignia", 31000));
        vehiclesList.add(new Vehicle("5924ZAB", Brand.CITROEN, "C4", 62000));
        vehiclesList.add(new Vehicle("6035CDE", Brand.PEUGEOT, "2008", 41000));
        vehiclesList.add(new Vehicle("7146FGH", Brand.HYUNDAI, "Tucson", 34000));

        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nKilometers of every vehicle:\n");
        AtomicInteger counter = new AtomicInteger(1);
        List<Integer> result = vehiclesList.stream()
            .map(Vehicle::getKm)
            .collect(Collectors.toList());
        result.forEach(km -> System.out.println("Vehicle "+counter.getAndIncrement()+": "+km+" km"));
        System.out.println("\n-----------------------------------------------------\n");
        
        
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nVehicles whose brand is 'AUDI':\n");
        List<Vehicle> audiVehicles = vehiclesList.stream()
            .filter(v -> v.getBrand().equals(Brand.AUDI))
            .collect(Collectors.toList());
        counter.set(1);
        audiVehicles.forEach(v -> System.out.println("Vehicle "+counter.getAndIncrement()+" -> | Model: "+v.getModel()+" | Matricle: "+v.getMatricle()+" |"));
        System.out.println("\n-----------------------------------------------------\n");
        

        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nVehicles sorted by kilometers:\n");
        List<Vehicle> kmsSortedList = vehiclesList.stream()
            .sorted((v1, v2) -> Integer.compare(v1.getKm(), v2.getKm()))
            .collect(Collectors.toList());
        counter.set(1);
        kmsSortedList.forEach(v -> System.out.println("Vehicle "+counter.getAndIncrement()+" -> "+v+"\n"));
        System.out.println("\n-----------------------------------------------------\n");


        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nVehicle Brands:\n");
        List<Brand> brandList = vehiclesList.stream()
            .map(Vehicle::getBrand)
            .distinct().collect(Collectors.toList());
        counter.set(1);
        brandList.forEach(v -> System.out.println("Brand "+counter.getAndIncrement()+": "+v));
        System.out.println("\n-----------------------------------------------------\n");


        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nVehicles with more than 20000 km:\n");
        counter.set(1);
        List<Vehicle> resultKms = vehiclesList.stream()
            .filter(v -> v.getKm() > 20000)
            .peek(v -> System.out.println("Vehicle "+counter.getAndIncrement()+" -> "+v+"\n"))
            .collect(Collectors.toList());
        System.out.println("\n-----------------------------------------------------\n");


        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("\nVehicles grouped by brand\n");
        Map<Brand, List<Vehicle>> brandGroupedMap = vehiclesList.stream()
            .collect(Collectors.groupingBy(Vehicle::getBrand));
        brandGroupedMap.forEach((b, v) -> {
            System.out.println("\nBrand: "+b+"\n");
            counter.set(1);
            v.forEach(s -> System.out.println("Vehicle "+counter.getAndIncrement()+" -> "+s));
        });
        System.out.println("\n-----------------------------------------------------\n");


        System.out.println("\n-----------------------------------------------------\n");
        System.out.print("Total sum of kilometers of all vehicles: ");
        Integer kmsTotalResult = vehiclesList.stream()
            .map(v -> v.getKm())
            .reduce(0, Integer::sum);
        System.out.println(kmsTotalResult+" km");
        System.out.println("\n-----------------------------------------------------\n");


        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("2 vehicles whose kms are <= 100,000\n");
        counter.set(1);
        vehiclesList.stream()
            .filter(v -> v.getKm() <= 100_000)
            .distinct()
            .limit(2)
            .forEach(v -> System.out.println("Vehicle "+counter.getAndIncrement()+" -> "+v));
        System.out.println("\n-----------------------------------------------------\n");
    
    }
}
