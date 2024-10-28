package chapter11;

import java.io.*;
import java.util.Scanner;

public class MySavings {

    private PiggyBank piggyBank = new PiggyBank();

    public static void main(String[] args) {
        MySavings mySavings = new MySavings();
        mySavings.loadPiggyBank(); // Load piggy bank data at startup
        mySavings.run();
    }

    /**
     * Run the console-based MySavings application.
     */
    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Show total in bank.");
            System.out.println("2. Add a penny.");
            System.out.println("3. Add a nickel.");
            System.out.println("4. Add a dime.");
            System.out.println("5. Add a quarter.");
            System.out.println("6. Take money out of bank.");
            System.out.println("7. Save Piggy Bank.");
            System.out.println("8. Load Piggy Bank.");
            System.out.println("0. Quit.");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Total in bank: $" + piggyBank.getTotal());
                case 2 -> {
                    piggyBank.addPenny();
                    System.out.println("Added a penny.");
                }
                case 3 -> {
                    piggyBank.addNickel();
                    System.out.println("Added a nickel.");
                }
                case 4 -> {
                    piggyBank.addDime();
                    System.out.println("Added a dime.");
                }
                case 5 -> {
                    piggyBank.addQuarter();
                    System.out.println("Added a quarter.");
                }
                case 6 -> {
                    System.out.print("Enter amount to take out: ");
                    double amount = scanner.nextDouble();
                    if (piggyBank.takeMoney(amount)) {
                        System.out.println("Took $" + amount + " out of the bank.");
                    } else {
                        System.out.println("Not enough money in the bank.");
                    }
                }
                case 7 -> savePiggyBank();
                case 8 -> loadPiggyBank();
                case 0 -> {
                    savePiggyBank();
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void savePiggyBank() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("piggy_bank.dat"))) {
            out.writeObject(piggyBank);
            System.out.println("Piggy bank saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPiggyBank() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("piggy_bank.dat"))) {
            piggyBank = (PiggyBank) in.readObject();
            System.out.println("Piggy bank loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved piggy bank found. Starting a new one.");
            piggyBank = new PiggyBank();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



