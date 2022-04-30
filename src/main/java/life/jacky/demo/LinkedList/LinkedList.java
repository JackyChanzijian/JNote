package life.jacky.demo.LinkedList;

public class LinkedList<E> {
    Node<E> head, tail;
    public int length = 0;

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
        System.out.println("Index: " + index);
        System.out.println("Length: " + length);
        if (index > length - 1) { return null; }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
}
