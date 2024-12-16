package masterys;

import java.util.LinkedList;

public class StackList {
    private LinkedList<Object> stack;

    public StackList() {
        stack = new LinkedList<>();
    }

    // Push an element to the stack
    public void push(Object item) {
        stack.addFirst(item);
    }

    // Pop an element from the stack
    public Object pop() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stack.removeFirst();
    }

    // Peek the top element of the stack
    public Object peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stack.getFirst();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        StackList stack = new StackList();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 30

        System.out.println("Top element after pop: " + stack.peek()); // Output: 20
        System.out.println("Is the stack empty? " + stack.isEmpty()); // Output: false
    }
}
