package masterys;

// Node class to represent each element in the stack
class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}

public class StackList {
    private Node top; // Top of the stack
    private int size; // Size of the stack

    // Constructor
    public StackList() {
        this.top = null;
        this.size = 0;
    }

    // Push operation: Adds an element to the stack
    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.next = top; // Link the new node to the previous top
        top = newNode;      // Update the top to the new node
        size++;
    }

    // Pop operation: Removes and returns the top element from the stack
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        Object data = top.data;
        top = top.next; // Update the top to the next node
        size--;
        return data;
    }

    // Peek operation: Returns the top element without removing it
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    // Main method to test the StackList implementation
    public static void main(String[] args) {
        StackList stack = new StackList();

        // Push elements onto the stack
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        // Peek at the top element
        System.out.println("Top of stack: " + stack.peek()); // Output: Cherry

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop()); // Output: Cherry
        System.out.println("Popped: " + stack.pop()); // Output: Banana

        // Check the size of the stack
        System.out.println("Stack size: " + stack.size()); // Output: 1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        // Pop the last element
        System.out.println("Popped: " + stack.pop()); // Output: Apple

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}
