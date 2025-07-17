package model.structure.queue;

// Queue.java
public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }

        T removed = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }

        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> current = front;
        int i = 0;
        while (current != null) {
            arr[i++] = current.data;
            current = current.next;
        }
        return arr;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
