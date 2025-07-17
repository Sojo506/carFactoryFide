package model.structure.queue;

import model.structure.linkedlist.Node;

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
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }

        T removed = front.getData();
        front = front.getNext();
        size--;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    public T dequeueAt(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (idx == 0) {
            return dequeue();
        }

        Node<T> prev = front;

        for (int i = 0; i < idx - 1; i++) {
            prev = prev.getNext();
        }

        Node<T> del = prev.getNext();
        prev.setNext(del.getNext());

        if (del == rear) {
            rear = prev;
        }
        size--;
        return del.getData();
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = front;
        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }
        return cur.getData();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cola vacía");
        }

        return front.getData();
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
            arr[i++] = current.getData();
            current = current.getNext();
        }
        return arr;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
