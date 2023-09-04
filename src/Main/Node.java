public class Node<E> {
    private E value;
    private Node<E> next;
    private Node<E> prev;

    Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }
    public void setValue(E value) {
        this.value = value;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public Node<E> getPrev() {
        return prev;
    }
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void insertAfter(Node<E> node) {
        node.setNext(this.getNext());
        node.setPrev(this);
        this.getNext().setPrev(node);
        this.setNext(node);
    }

    public void insertBefore(Node<E> node) {
        node.setNext(this);
        node.setPrev(this.getPrev());
        this.getPrev().setNext(node);
        this.setPrev(node);
    }

    public void remove() {
        this.getNext().setPrev(this.getPrev());
        this.getPrev().setNext(this.getNext());
    }
}