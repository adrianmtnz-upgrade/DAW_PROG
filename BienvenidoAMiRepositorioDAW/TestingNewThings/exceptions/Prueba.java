package TestingNewThings.exceptions;

public class Prueba {
    public static void main(String[] args) {
        try {
            // Simulate a scenario where DataReaderException is thrown
            throw new DataReaderException("Custom error message for testing");
        } catch (DataReaderException e) {
            // Catch the exception and print the message
            System.out.println("Caught DataReaderException: " + e.getMessage());
        }
}
}
