package chapter11;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MySavings {

    private PiggyBank piggyBank = new PiggyBank(); // Create an instance of PiggyBank

    public static void main(String[] args) {
        MySavings mySavings = new MySavings(); // Initialize the MySavings application
        mySavings.loadPiggyBank(); // Load piggy bank data at startup
        mySavings.run(); // Run the application
    }

    /**
     * Run the console-based MySavings application.
     */
    private void run() {
        Scanner scanner = new Scanner(System.in); // Create a scanner for user input
        boolean running = true; // Flag to control the main loop

        while (running) { // Start a loop to keep the program running until the user quits
            // Display the menu options
            System.out.println("\n1. Show total in bank.");
            System.out.println("2. Add a penny.");
            System.out.println("3. Add a nickel.");
            System.out.println("4. Add a dime.");
            System.out.println("5. Add a quarter.");
            System.out.println("6. Take money out of bank.");
            System.out.println("7. Save Piggy Bank.");
            System.out.println("8. Load Piggy Bank.");
            System.out.println("0. Quit.");
            System.out.print("Enter your choice: "); // Prompt for user input

            int choice = scanner.nextInt(); // Read the user's choice

            switch (choice) { // Process the user's choice
                case 1 -> {
                    // Format and display the total amount in the piggy bank
                    DecimalFormat df = new DecimalFormat("#,###.00"); // Format the total with commas
                    System.out.println("Total in bank: $" + df.format(piggyBank.getTotal())); // Display the formatted total
                }
                case 2 -> {
                    piggyBank.addPenny(); // Add a penny to the piggy bank
                    System.out.println("Added a penny."); // Notify the user
                }
                case 3 -> {
                    piggyBank.addNickel(); // Add a nickel to the piggy bank
                    System.out.println("Added a nickel."); // Notify the user
                }
                case 4 -> {
                    piggyBank.addDime(); // Add a dime to the piggy bank
                    System.out.println("Added a dime."); // Notify the user
                }
                case 5 -> {
                    piggyBank.addQuarter(); // Add a quarter to the piggy bank
                    System.out.println("Added a quarter."); // Notify the user
                }
                case 6 -> {
                    System.out.print("Enter amount to take out: "); // Prompt for the amount to withdraw
                    double amount = scanner.nextDouble(); // Read the withdrawal amount
                    if (piggyBank.takeMoney(amount)) { // Check if there is enough money
                        System.out.println("Took $" + amount + " out of the bank."); // Success message
                    } else {
                        System.out.println("Not enough money in the bank."); // Error message
                    }
                }
                case 7 -> savePiggyBank(); // Save the piggy bank data
                case 8 -> loadPiggyBank(); // Load the piggy bank data
                case 0 -> {
                    savePiggyBank(); // Save the piggy bank data before quitting
                    System.out.println("Goodbye!"); // Farewell message
                    running = false; // Stop the loop, ending the program
                }
                default -> System.out.println("Invalid choice. Please try again."); // Handle invalid choices
            }
        }

        scanner.close(); // Close the scanner
    }

    private void savePiggyBank() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("piggy_bank.dat"))) {
            out.writeObject(piggyBank); // Save the piggy bank to a file
            System.out.println("Piggy bank saved."); // Notify the user
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IO errors
        }
    }

    private void loadPiggyBank() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("piggy_bank.dat"))) {
            piggyBank = (PiggyBank) in.readObject(); // Load the piggy bank from a file
            System.out.println("Piggy bank loaded."); // Notify the user
        } catch (FileNotFoundException e) {
            System.out.println("No saved piggy bank found. Starting a new one."); // Handle case where no saved data exists
            piggyBank = new PiggyBank(); // Initialize a new piggy bank
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle any errors during loading
        }
    }
}

