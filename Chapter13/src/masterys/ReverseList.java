/*

Program: ReverseList         Last Date of this Revision: December 18, 2024

Purpose: The ReverseList application allows the user to enter up to 10 numbers. 
It stores them in a stack, and when the user finishes inputting, it reverses and displays the list.

Author: 

School: CHHS

Course: Computer Programming 30

*/
package masterys;

import java.util.Scanner;
import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        // Initialize Scanner and Stack
        Scanner scanner = new Scanner(System.in);  
        Stack<Integer> stack = new Stack<>();     

        // Prompt for input
        System.out.println("Enter up to 10 numbers (enter 999 to quit):");

        // Loop for user input
        while (true) {
            int number = scanner.nextInt();  // Read user input
            if (number == 999) break;        // Stop if 999 is entered

            if (stack.size() < 10) {
                stack.push(number);  // Push number onto stack
            } else {
                System.out.println("You have entered the maximum of 10 numbers.");
                break;  // Stop if 10 numbers are entered
            }
        }

        // Output the reversed list
        System.out.println("The list reversed is:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");  // Pop from the stack and print each number
        }

        // Close the scanner
        scanner.close();  // Close the scanner object
    }
}




