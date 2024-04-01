import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ReadTextFile {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = ""; // items in ArrayList

        ArrayList <String> jonsList = new ArrayList<>();

        jonsList.add("Aliens");
        jonsList.add("Bunny");
        jonsList.add("Horse");
        jonsList.add("Human Being");
        jonsList.add("Cat");

        try
        {
            File workDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file,CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0; // This just reads how many lines are printed out
                while (reader.ready()){
                    rec = reader.readLine(); // This reads every line
                    line++;

                    System.out.printf("\nLine %4d %6s  ", line, rec); // Format on how the lines will be printed out in terminal
                }
                reader.close(); // Stops reader
                System.out.println("\n\nData file read!"); // Just tells the user the data in the file has been read.

                System.out.println("\n\nYou selected file " + selectedFile.getName()); // selectedFile is what the user selected in JFileChooser. Will show its path to file.
                int totalCharacters = 0;
                int totalWords = 0;
                String[] words; // New array to use to count words and characters in every array made

                for (String w: jonsList){

                    words = w.split(" "); // String[] words... splits every word by space in Array List
                    // System.out.println("There are " + w.length() + " characters in the array."); ** amount of characters in array **
                    // System.out.println("There are " + words.length + " words in the array."); ** amount of words based on how many spaces the array item has **

                    totalCharacters += w.length();
                    totalWords += words.length;
                }
                System.out.println("Total number of words in file is: " + totalWords); // outside for loop to show final word count
                System.out.println("Total number of characters in file is " + totalCharacters);// outside for loop to show final character count
            }
            else
            {
                System.out.println("No file selected! Run program again and select a file.");
            }


            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
