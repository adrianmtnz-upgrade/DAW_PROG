package binary;

import java.io.*;
import java.util.Scanner;

public class BinFile {

    // Relative path to the binary file
    String fileRelPath = "BienvenidoAMiRepositorioDAW\\TestingNewThings\\readingAndWritingFiles\\binary\\people.bin";

    // Method to write a single Person object to the binary file
    private void writeBinary(){
        try {
            FileOutputStream file = new FileOutputStream(fileRelPath);
            ObjectOutputStream writer = new ObjectOutputStream(file);

            writer.writeObject(new Person(22, "Adrian Martinez"));
            System.out.println("\nObject added with success");
            writer.close();
        } catch (IOException error) { 
            error.printStackTrace(System.out); 
        }
    }

    // Method to read and display all Person objects from the binary file
    private void readBinary() throws ClassNotFoundException{
        Person person;
        ObjectInputStream reader = null;

        try {
            FileInputStream file = new FileInputStream(fileRelPath);
            reader = new ObjectInputStream(file);

            while(true){
                person = (Person) reader.readObject();
                person.showData();
            } 
        } catch(EOFException exception){
            // End of file reached
            return;
        } catch (IOException error) {
            error.printStackTrace(System.out); 
        } finally {      
            try {               // Close the reader
                if (reader != null) reader.close();
            } catch (IOException error) { 
                error.printStackTrace(System.out); 
            }
        }
    }

    // Method to append multiple Person objects to the binary file
    private void addBinary(int age, String name){
        try {
            FileOutputStream file = new FileOutputStream(fileRelPath, true);
            AddContent writer = new AddContent(file);

            writer.writeObject(new Person(age, name));
            System.out.println("Object added with success\n");
            writer.close();
        } catch (IOException error) { 
            error.printStackTrace(System.out); 
        }
    }

    // Method to delete the binary file
    private void deleteBinary(){
        File file = new File(fileRelPath);
        if (file.delete()){
            System.out.println("File deleted succesfully");
        } else {
            System.out.println("Error, couldn't delete the file");
        }
    }

    // Main method to test writing, appending, and reading from the binary file
    public static void main(String[] args) throws ClassNotFoundException {
        BinFile test = new BinFile();
        Scanner user = new Scanner(System.in);

        test.writeBinary();

        test.addBinary(39, "Juanjo Abenza");
        test.addBinary(28, "Laura Garcia");
        test.addBinary(35, "Carlos Fernandez");
        
        test.readBinary();
        
        System.out.println("Do you want to delete the file?: (Y/N)"+"\n");
        
        if (user.next().toUpperCase().equals("Y")) test.deleteBinary();
        System.out.println();
        user.close();
    }
}
