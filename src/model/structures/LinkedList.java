package model.structures;

import java.util.Random;
import model.Car;
import model.Material;
import model.Order;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public void add(T data) {
        /*
        if (data != null && !(data instanceof Material) && !(data instanceof Car) && !(data instanceof Order) && !(data instanceof Boolean)) {
            throw new IllegalArgumentException("Objeto no permitido");
        }
         */

        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    public T getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public void setElement(int index, T data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(data);
    }

    public int indexOf(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if ((data == null && current.getData() == null) || (data != null && data.equals(current.getData()))) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public T getRandomElement() {
        Node<T> current = head;

        if (isEmpty()) {
            throw new RuntimeException("La lista está vacía");
        }

        Random rand = new Random();
        int r = rand.nextInt(size());

        current = head;
        for (int i = 0; i < r; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        T removedData;

        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
        } else {
            Node<T> current = head;
            // Llegar al nodo anterior al que se eliminará
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedData = current.getNext().getData();
            // Saltar el nodo que se elimina
            current.setNext(current.getNext().getNext());
        }

        size--;
        return removedData;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
