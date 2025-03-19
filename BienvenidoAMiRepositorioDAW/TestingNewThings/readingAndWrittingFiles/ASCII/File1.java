package readingAndWrittingFiles.ASCII;

import java.io.*;

public class File1 {
    public static void main(String[] args) {
        
        String writtenMessage = "This phrase must be written first before being read";
        String readMessageLn1 = "";
        String readMessageLn2 = "";
        
        try{
            FileWriter file = new FileWriter("testFile.txt");
            file.write("----- MY TEST FILE -----\n");
            file.write(writtenMessage);
            file.close();

        }catch (Exception ex) { ex.printStackTrace(); }

        try{
            FileReader reader = new FileReader("testFile.txt");
            BufferedReader BR = new BufferedReader(reader);
            readMessageLn1 = BR.readLine();
            readMessageLn2 = BR.readLine();
            BR.close();
        }catch (Exception ex) { ex.printStackTrace(); }

        System.out.println("The saved message is: \n" + readMessageLn1 + "\n" + readMessageLn2);
    }
}
