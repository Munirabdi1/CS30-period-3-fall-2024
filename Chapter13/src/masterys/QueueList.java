package masterys;

public class QueueList {

    // Node class to represent each element in the queue
    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front; // The front of the queue
    private Node rear;  // The rear of the queue
    private int size;   // Size of the queue

    // Constructor
    public QueueList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Enqueue operation: Adds an element to the queue
    public void enqueue(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode; // If the queue is empty, front and rear are the same
        } else {
            rear.next = newNode;   // Link the new node at the end of the queue
            rear = newNode;        // Update the rear to the new node
        }
        size++;
    }

    // Dequeue operation: Removes and returns the front element from the queue
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        Object data = front.data;
        front = front.next; // Move the front to the next node
        if (front == null) {
            rear = null; // If the queue becomes empty, rear should also be null
        }
        size--;
        return data;
    }

    // Peek operation: Returns the front element without removing it
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot peek.");
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

    // Main method to test the QueueList implementation
    public static void main(String[] args) {
        QueueList queue = new QueueList();

        // Enqueue elements
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");

        // Peek at the front element
        System.out.println("Front of queue: " + queue.peek()); // Output: Apple

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Apple
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Banana

        // Check the size of the queue
        System.out.println("Queue size: " + queue.size()); // Output: 1

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: false

        // Dequeue the last element
        System.out.println("Dequeued: " + queue.dequeue()); // Output: Cherry

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}