package readingAndWrittingFiles.ASCII;

import java.io.*;

public class File1 {
    public static void main(String[] args) throws IOException{
        
        File myFile = new File("testFile.txt");
        String writtenMessage = "This phrase must be written first before being read";
        String readMessageLn1 = "";
        String readMessageLn2 = "";
        if(!myFile.exists()){
            try{
                myFile.createNewFile();
                System.out.println(myFile.getName() + " ha sido creado en " + myFile.getAbsolutePath());
            
            } catch(IOException ex){ ex.printStackTrace(System.out); }
        }
        
        System.out.println("\n" +
            "Can be read?         " + myFile.canRead() + "\n" +
            "Can be written?      " + myFile.canWrite() + "\n" +
            "Can execute?         " + myFile.canExecute() + "\n" +
            "It's a directory?    " + myFile.isDirectory() + "\n" +
            "It's a file?         " + myFile.isFile() + "\n" +
            "Last update date:    " + myFile.lastModified() + "\n" +
            "Size:                " + myFile.length()+" bytes" + "\n"
        );

        try{
            FileWriter file = new FileWriter(myFile);
            file.write("----- MY TEST FILE -----\n");
            file.write(writtenMessage);
            file.close();

        }catch (IOException ex) { ex.printStackTrace(System.out); }

        try{
            FileReader reader = new FileReader(myFile);
            BufferedReader BR = new BufferedReader(reader);
            readMessageLn1 = BR.readLine();
            readMessageLn2 = BR.readLine();
            BR.close();

        }catch (Exception ex) { ex.printStackTrace(System.out); }

        System.out.println("The saved message is: " +"\n"+"\n"+ readMessageLn1 + "\n" + readMessageLn2);
    }
}
