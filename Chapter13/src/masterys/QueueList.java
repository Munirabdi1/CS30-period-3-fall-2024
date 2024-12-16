package masterys;

import java.util.LinkedList;

public class QueueList {
    // Internal LinkedList to represent the queue
    private LinkedList<Integer> queue;

    // Constructor
    public QueueList() {
        queue = new LinkedList<>();
    }

    // Add an element to the queue (enqueue)
    public void enqueue(int item) {
        queue.addLast(item);
        System.out.println("Enqueued: " + item);
    }

    // Remove an element from the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int item = queue.removeFirst();
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Peek the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queue.getFirst();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Print all elements in the queue
    public void printQueue() {
        System.out.println("Current Queue: " + queue);
    }

    // Main method to test the QueueList class
    public static void main(String[] args) {
        QueueList queue = new QueueList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.printQueue();

        System.out.println("Front Element: " + queue.peek());
        queue.dequeue();
        queue.printQueue();

        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
}

