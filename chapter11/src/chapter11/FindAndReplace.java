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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        System.out.print("Enter search word or phrase: ");
        String searchWord = scanner.nextLine();

        System.out.print("Enter replacement word or phrase: ");
        String replaceWord = scanner.nextLine();

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            // Read the file content line by line
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            // Replace occurrences of searchWord with replaceWord
            String newContent = content.toString().replaceAll(searchWord, replaceWord);

            // Write the new content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(newContent);
            writer.close();

            System.out.println("Replacement successful!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
//