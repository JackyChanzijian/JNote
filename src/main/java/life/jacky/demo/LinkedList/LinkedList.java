package life.jacky.demo.LinkedList;

public class LinkedList<E> {
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

    @Override
    public String toString() {
        return name;
    }
}
