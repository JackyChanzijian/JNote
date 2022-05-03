package life.jacky.demo.LinkedList;

import java.io.Serializable;

public class Node<E> implements Serializable {
    E element;
    Node<E> next;
    Node<E> previous;

    Node(E element) {
        this.element = element;
    }
}
