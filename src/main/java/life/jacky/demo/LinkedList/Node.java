package life.jacky.demo.LinkedList;

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    Node(E element) {
        this.element = element;
    }
}
