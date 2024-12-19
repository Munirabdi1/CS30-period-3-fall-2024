package chapter11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*

Program: WordCount                Last Date of this Revision: December 19, 2024

Purpose: The WordCount program reads a text file, counts the total number of words, 
         and calculates the average length of the words. It ignores non-alphabetical 
         characters when determining word lengths.

Author: 

School: CHHS

Course: Computer Programming 30

*/

public class WordCount {
    public static void main(String[] args) {
        System.out.println("=== Word Count Program ===");
        System.out.println("This program reads a file and calculates the total number of words and their average length.\n");

        // Specify the file path (adjust as needed for your setup)
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
                totalLetters += word.replaceAll("[^a-zA-Z]", "").length();  // Count letters, ignore non-alphabetic chars
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

