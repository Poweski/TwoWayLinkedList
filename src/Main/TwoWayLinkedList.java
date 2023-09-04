public class TwoWayLinkedList<E> implements IList<E> {
    Node<E> tail;

    public TwoWayLinkedList() {
        tail = null;
    }

    public Node<E> getNode(int index) throws IndexOutOfBoundsException {
        if (tail == null | index < 0)
            throw new IndexOutOfBoundsException("An index out of range was specified!");
        Node<E> node;
        int size = this.size();
        int counter;
        if (index < size/2) {
            counter = 0;
            node = tail.getNext();
            while (node != tail && counter < index) {
                counter++;
                node = node.getNext();
            }
        }
        else {
            counter = size-1;
            node = tail;
            boolean flag = true;
            while ((flag | node != tail) && counter > index) {
                flag = false;
                counter--;
                node = node.getPrev();
            }
        }
        if (node == tail && counter != index)
            throw new IndexOutOfBoundsException("An index out of range was specified!");
        return node;
    }

    public Node<E> getNode(E value) {
        if (tail == null)
            return null;
        Node<E> node = tail.getNext();
        while (node != tail && !value.equals(node.getValue()))
            node = node.getNext();
        if (node == tail && !value.equals(node.getValue()))
            return null;
        return node;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void clear() {
        tail = null;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public int size() {
        if (tail == null)
            return 0;
        Node<E> node = tail;
        boolean flag = true;
        int counter = 0;
        while (node != tail || flag) {
            flag = false;
            counter++;
            node = node.getNext();
        }
        return counter;
    }

    @Override
    public int indexOf(E value) {
        if (tail == null)
            return -1;
        Node<E> node = tail.getNext();
        int counter = 0;
        while (node != tail && !node.getValue().equals(value)){
            counter++;
            node = node.getNext();
        }
        if (node == tail && !node.getValue().equals(value))
            return -1;
        return counter;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        Node<E> node = getNode(index);
        return node.getValue();
    }

    @Override
    public E set(int index, E value) throws IndexOutOfBoundsException {
        Node<E> node = getNode(index);
        E retValue = node.getValue();
        node.setValue(value);
        return retValue;
    }

    @Override
    public boolean add(E value) {
        Node<E> newNode = new Node<>(value);
        if (tail == null) {
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            return true;
        }
        tail.insertAfter(newNode);
        tail = newNode;
        return true;
    }

    @Override
    public boolean add(int index, E value) {
        Node<E> newNode = new Node<>(value);
        if (tail == null && index == 0) {
            tail = newNode;
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            return true;
        }
        else if (tail == null)
            throw new IndexOutOfBoundsException();
        else {
            int size = this.size();
            Node<E> node;
            if (index < size/2) {
                node = getNode(index-1);
                node.insertAfter(newNode);
            }
            else {
                node = getNode(index);
                node.insertBefore(newNode);
            }
            if (index == size-1)
                tail = newNode;
        }
        return true;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        Node<E> node = getNode(index);
        if (tail == node)
            tail = null;
        else
            node.remove();
        return node.getValue();
    }

    @Override
    public boolean remove(E value) {
        Node<E> node = getNode(value);
        if (node == null)
            return false;
        if (tail == node)
            tail = null;
        else
            node.remove();
        return true;
    }
}