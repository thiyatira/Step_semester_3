package data_structures.assigment_problems;

// Fixed-capacity bus bay built on an int ring buffer with O(1) operations at both ends.
public class BusBay {

    private final int[] slots;
    private int front;
    private int size;

    public BusBay(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        slots = new int[capacity];
    }

    public boolean insertFront(int bus) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + slots.length) % slots.length;
        slots[front] = bus;
        size++;
        return true;
    }

    public boolean insertLast(int bus) {
        if (isFull()) {
            return false;
        }
        slots[(front + size) % slots.length] = bus;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % slots.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : slots[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : slots[(front + size - 1) % slots.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == slots.length;
    }
}
