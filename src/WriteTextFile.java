import java.io.*; // Java write import
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class WriteTextFile {
    public static void main(String[] args) {
        ArrayList <String> jonsList = new ArrayList<>(); // ArrayList object itself does not throw any checked exceptions, so it can be safely done outside the try-catch.

        jonsList.add("Aliens"); // name of ArrayList is jonsList
        jonsList.add("Bunny");
        jonsList.add("Horse");
        jonsList.add("Human Being");
        jonsList.add("Cat");

        File workingDirectory = new File(System.getProperty("user.dir")); // Creating file called "workingDirectory" and uses the current working directory(the value of "user.dir") of the Java process.
        Path file = Paths.get(workingDirectory.getPath()+ "/src/randomData.txt"); // This gets the path for File workingDirectory. /src/randomData.txt is added to the end of the workingDirectory path, creating a complete file path.

        try { // "Try-block" used to handle any code that throw an error(exception). Maintains program flow
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (String rec : jonsList)
            {
                writer.write(rec, 0, rec.length()); // syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line
            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("File has been written!");


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}