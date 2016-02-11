import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Joeri on 11-2-2016.
 */
public class Datareader {

    public Datareader() {

    }

    public Dataset readData(String filename) {

        BufferedReader reader = null;
        Dataset dataset = new Dataset();
        try {
            reader = new BufferedReader(new FileReader("input/" + filename + ".in"));

            String line = reader.readLine();
            String[] split = line.split(" ");

            //TODO do stuff

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the reader");
            }
        }
        return dataset;
    }
}
