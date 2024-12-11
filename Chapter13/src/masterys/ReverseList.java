package masterys; 

import java.util.Scanner;
import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        final int MAX_NUMBERS = 10; // Maximum numbers to accept
        final int QUIT_VALUE = 999; // Sentinel value to terminate input

        System.out.println("Enter up to 10 numbers (999 to quit):");

        for (int i = 0; i < MAX_NUMBERS; i++) {
            System.out.print("Enter a number (999 to quit): ");
            if (!scanner.hasNextInt()) { // Ensure input is an integer
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Skip invalid input
                continue;
            }
            int input = scanner.nextInt();

            if (input == QUIT_VALUE) {
                break; // Stop taking inputs if 999 is entered
            }

            stack.push(input); // Add the number to the stack
        }

        System.out.print("The list reversed is: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

