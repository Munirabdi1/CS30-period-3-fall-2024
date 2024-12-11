package chapter11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        // Use the absolute path temporarily for testing
        File file = new File("../chapter11/src/chapter11/wordcount");

        try {
            // Create a scanner to read the file
            Scanner scanner = new Scanner(file);

            int wordCount = 0;
            int totalLetters = 0;

            // Read through the file word by word
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordCount++;  // Count the word
                totalLetters += word.replaceAll("[^a-zA-Z]", "").length();  // Count the letters, ignoring non-alphabetical characters
            }

            // Calculate the average word length
            double averageWordLength = (wordCount == 0) ? 0 : (double) totalLetters / wordCount;

            // Output the results
            System.out.println("Number of words: " + wordCount);
            System.out.println("Average word length: " + averageWordLength);

            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
