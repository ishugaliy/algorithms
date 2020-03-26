package datatype;

public class Node<T> {

    private T value;
    private Node<T> prev;
    private Node<T> next;

    public Node() { }

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> prev, Node<T> next) {
        this(value);
        this.prev = prev;
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    @Override
    public String toString() {
        return "Node{ value=" + value + '}';
    }
}
