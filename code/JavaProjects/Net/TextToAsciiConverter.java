import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextToAsciiConverter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java TextToAsciiConverter <input_file_path> <output_file_path>");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            convertTextToAscii(inputFilePath, outputFilePath);
            System.out.println("ASCII conversion completed successfully. Output saved to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertTextToAscii(String inputFilePath, String outputFilePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character + " ");
            }
        }
    }
}
