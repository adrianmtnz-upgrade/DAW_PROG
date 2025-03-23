package TestingNewThings.readingAndWritingFiles.ASCII;

import java.io.*;
import java.util.Scanner;


public class File1 {
    File myFile;
    String writtenMessage = "This phrase must be written first before being read";
    String content = "";

    private void createTextFile(){
        myFile = new File("testFile.txt");

        if(!myFile.exists()){
            try{
                myFile.createNewFile();
                System.out.println(myFile.getName() + " has been created on: " + myFile.getAbsolutePath());
            
            } catch(IOException ex){ ex.printStackTrace(System.out); }
        }
        DateFormatter lastModifiedFormated = new DateFormatter();
        String dataFormatted = lastModifiedFormated.dateFormat(myFile.lastModified());

        System.out.println("\n" +
            "Can be read?         " + myFile.canRead() + "\n" +
            "Can be written?      " + myFile.canWrite() + "\n" +
            "Can execute?         " + myFile.canExecute() + "\n" +
            "It's a directory?    " + myFile.isDirectory() + "\n" +
            "It's a file?         " + myFile.isFile() + "\n" +
            "Last update date:    " + dataFormatted + "\n" +
            "Size:                " + myFile.length()+" bytes" + "\n"
        );
    }

    private void deleteTextFile(){
        if (myFile.delete()){
            System.out.println("File deleted succesfully");
        } else {
            System.out.println("Error, couldn't delete the file");
        }
    }

    private void writeTextFile(String line){
            try{
                FileWriter writer = new FileWriter(myFile, true);
                writer.write(line);
                writer.close();
    
            }catch (IOException ex) { ex.printStackTrace(System.out); }

    }

    private void readTextFile(){
        try{
            FileReader reader = new FileReader(myFile);
            BufferedReader BR = new BufferedReader(reader);
            content = BR.readLine();

            while(content != null){
                System.out.println(content);
                content = BR.readLine();
            }
            System.out.println("\n");
            BR.close();

        }catch (Exception ex) { ex.printStackTrace(System.out); }
    }
    public static void main(String[] args) throws IOException{
       
        File1 file = new File1();
        Scanner user = new Scanner(System.in);

        file.createTextFile();
        file.writeTextFile("----- MY TEST FILE -----"+"\n"+"\n");
        file.writeTextFile(file.writtenMessage +"\n");

        System.out.println("\n"+"The saved message is: " +"\n"+"\n");
        file.readTextFile();

        file.writeTextFile("Another line created"+ "\n");
        file.readTextFile();

        System.out.println("Do you want to delete the file?: (Y/N)"+"\n");
       
        if (user.next().toUpperCase().equals("Y")) file.deleteTextFile();
        System.out.println();
        user.close();
    }
}
