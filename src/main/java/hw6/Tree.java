package hw6;

public class Tree<E extends Comparable<? super E>> {

    private Node<E> root;
    private int maxHeight;

    public Tree(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public boolean add(E value) throws IndexOutOfBoundsException {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) {
            this.root = newNode;
            return true;
        }

        NodeAndParent nodeAndParent = find(value);
        if (nodeAndParent.current != null) {
            return false;
        }
        if (nodeAndParent.height >= maxHeight) {
            throw new IndexOutOfBoundsException("Превышена максимальная высота дерева");
        }

        Node<E> parent = nodeAndParent.parent;

        assert parent != null;
        if (parent.shouldBeLeft(value)) {
            parent.setLeftChild(newNode);
        } else {
            parent.setRightChild(newNode);
        }

        return true;
    }

    private NodeAndParent find(E value) {
        Node<E> parent = null;
        Node<E> current = this.root;
        int depth = 0;

        while (current != null) {
            if (current.getValue().equals(value)) {
                return new NodeAndParent(current, parent, depth);
            }

            parent = current;
            if (current.shouldBeLeft(value)) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            depth++;
        }

        return new NodeAndParent(null, parent, depth);
    }

    public boolean remove(E value) {
        NodeAndParent nodeAndParent = find(value);
        Node<E> parent = nodeAndParent.parent;
        Node<E> removedNode = nodeAndParent.current;

        if (removedNode == null) {
            return false;
        }

        if (removedNode.isLeaf()) {
            removeLeafNode(parent, removedNode);
        } else if (hasOnlySingleChildNode(removedNode)) {
            removeNodeWithSingleChild(parent, removedNode);
        } else {
            removeCommonNode(parent, removedNode);
        }

        return true;
    }

    private void removeCommonNode(Node<E> parent, Node<E> removedNode) {
        Node<E> successor = getSuccessor(removedNode);
        if (removedNode == root) {
            root = successor;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(successor);
        } else {
            parent.setRightChild(successor);
        }

        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != removedNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }

        return successor;
    }

    private void removeNodeWithSingleChild(Node<E> parent, Node<E> removedNode) {
        Node<E> childNode = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();

        if (removedNode == root) {
            root = childNode;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(childNode);
        } else {
            parent.setRightChild(childNode);
        }
    }

    private void removeLeafNode(Node<E> parent, Node<E> removedNode) {
        if (removedNode == root) {
            root = null;
        } else if (parent.shouldBeLeft(removedNode.getValue())) {
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    private boolean hasOnlySingleChildNode(Node<E> removedNode) {
        return removedNode.getLeftChild() != null ^ removedNode.getRightChild() != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private static int height(Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }

    private class NodeAndParent {
        Node<E> current;
        Node<E> parent;
        int height;

        NodeAndParent(Node<E> current, Node<E> parent, int height) {
            this.current = current;
            this.parent = parent;
            this.height = height;
        }
    }
}
