package masterys;

import java.util.Scanner;
import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter up to 10 numbers (enter 999 to quit):");

        while (true) {
            int number = scanner.nextInt();
            if (number == 999) break;

            if (stack.size() < 10) {
                stack.push(number);
            } else {
                System.out.println("You have entered the maximum of 10 numbers.");
                break;
            }
        }

        System.out.println("The list reversed is:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        scanner.close();
    }
}


