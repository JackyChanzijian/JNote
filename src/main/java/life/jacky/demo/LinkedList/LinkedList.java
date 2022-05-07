package life.jacky.demo.LinkedList;

import java.io.Serializable;

public class LinkedList<E> implements Serializable {
    String name;
    Node<E> head, tail;
    public int length = 0;

    public LinkedList(String name) {
        this.name = name;
    }

    public LinkedList() {

    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<E>(element);
        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;   // Set both head and tail to the new Node if the list is empty
        }
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length++;
    }

    public E get(int index) {
        if (index > length - 1) { return null; }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    public Node getNode(int index) {
        if (index > length - 1) { return null; }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    public E[] toArray() {
        E[] elements = (E[]) new Object[length];
        for (int i = 0; i < length; i++) {
            elements[i] = get(i);
        }
        return elements;
    }
    public void clear() {
        head = tail = null;
        length = 0;
    }
    public void deleteNode(E element) {
        if (length == 0) return;
        if (length == 1) {
            head = tail = null;
        }
        for (int i = 0; i < length; i++) {
            if (getNode(i) == element) {
                getNode(i - 1).next = getNode(i + 1);
            }
        }
        length--;
    }
    @Override
    public String toString() {
        return name;
    }
}
