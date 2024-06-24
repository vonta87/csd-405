// Javonta Young Assignent 5 program 2 June 22 2024
// This program is to make a file named data.file and add 10 random numbers to it
// Once the file is created I am to open the file to see what was saved to the file

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class CreateFileExample {
    public static void main(String[] args) {
        String filename = "data.file";
        Random random = new Random();

        // Step 1: Create a new file if it does not exist
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File created: " + filename);
            } else {
                System.out.println("File already exists: " + filename);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
            return;
        }

        // Step 2: Write or append 10 randomly generated numbers to the file
        try (FileWriter fw = new FileWriter(file, true); BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
                bw.write(randomNumber + " ");
            }
            bw.newLine(); // Add a new line for separation
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Step 3: Read the data from the file and display it
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            System.out.println("Data in file:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
