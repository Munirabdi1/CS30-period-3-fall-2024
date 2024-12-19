/*

Program: FindAndReplace         Last Date of this Revision: december 18, 2024

Purpose: The FindAndReplace application reads a file, searches for a specified word or phrase, and replaces it with another word or phrase. It then saves the updated content back to the file.

Author: 

School: CHHS

Course: Computer Programming 30

*/

package chapter11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindAndReplace {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the file name
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        // Prompt the user to enter the word/phrase to search for
        System.out.print("Enter search word or phrase: ");
        String searchWord = scanner.nextLine();

        // Prompt the user to enter the word/phrase to replace with
        System.out.print("Enter replacement word or phrase: ");
        String replaceWord = scanner.nextLine();

        try {
            // Create a File object with the specified file name
            File file = new File(fileName);

            // Check if the file exists
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            // BufferedReader to read the file content
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            // Read the file content line by line
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            // Replace all occurrences of the search word/phrase with the replacement word/phrase
            String newContent = content.toString().replaceAll(searchWord, replaceWord);

            // BufferedWriter to write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(newContent);
            writer.close();

            // Inform the user that the replacement was successful
            System.out.println("Replacement successful!");
        } catch (IOException e) {
            // Handle any I/O exceptions and display an error message
            System.out.println("Error: " + e.getMessage());
        }
    }
}
