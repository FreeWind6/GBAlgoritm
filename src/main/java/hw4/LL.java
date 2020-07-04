package hw4;

public class LL {

    private Node first;
    private Node last;
    private int size = 0;

    private static class Node {
        int element;
        Node next;
        Node previous;

        public Node(int element) {
            this.element = element;
        }
    }

    public void add(int element) {
        Node newNode = new Node(element);
        if (first == null) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (get(i) == element) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.element;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node node = findNodeBeforeByIndex(index);
            Node tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
        return false;
    }

    private Node findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        Node node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Node findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Node node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }
}
