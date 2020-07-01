package hw3;

import java.util.NoSuchElementException;

public class Deque<T> {
    private Stack<T> rightStack = new Stack<>();

    private Stack<T> leftStack = new Stack<>();


    public void insertRight(T item) {
        rightStack.push(item);
    }

    public void insertLeft(T item) {
        leftStack.push(item);
    }

    public T removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        balanceIfNeed();

        if (rightStack.isEmpty() && leftStack.size() == 1) {
            return leftStack.pop();
        }

        return rightStack.pop();
    }

    public T removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        balanceIfNeed();

        if (leftStack.isEmpty() && rightStack.size() == 1) {
            return rightStack.pop();
        }

        return leftStack.pop();
    }

    public int size() {
        return leftStack.size() + rightStack.size();
    }

    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    private void balanceIfNeed() {
        if ((leftStack.isEmpty() && rightStack.size() > 1) || (rightStack.isEmpty() && leftStack.size() > 1)) {
            boolean isLeftStackEmpty = leftStack.isEmpty();
            Stack<T> notEmptyStack = leftStack.isEmpty() ? rightStack : leftStack;

            Stack<T> buffLeft = new Stack<>();
            Stack<T> buffRight = new Stack<>();


            Object[] buff = new Object[notEmptyStack.size()]; // порядок элементов должен быть сохранен
            Object[] left = new Object[notEmptyStack.size() / 2 + 1];
            Object[] right = new Object[notEmptyStack.size() / 2 + 1];

            int k = 0;
            while (!notEmptyStack.isEmpty()) {
                buff[k] = notEmptyStack.pop();
                k++;
            }

            if (isLeftStackEmpty) {
                buff = reverseArray(buff);
            }

            int sizeOfLeftPart = buff.length / 2;

            System.arraycopy(buff, 0, left, 0, sizeOfLeftPart);
            System.arraycopy(buff, sizeOfLeftPart, right, 0, buff.length - sizeOfLeftPart);

            Object[] reversedLeft = reverseArray(left);
            for (int i = 0; i < reversedLeft.length; i++) {
                if (reversedLeft[i] != null) {
                    buffLeft.push((T) reversedLeft[i]);
                }
            }

            for (int i = 0; i < right.length; i++) {
                if (right[i] != null) {
                    buffRight.push((T) right[i]);

                }
            }

            leftStack = buffLeft;
            rightStack = buffRight;
        }
    }

    private static Object[] reverseArray(Object[] rawArray) {
        Object[] reversedArray = new Object[rawArray.length];
        for (int i = rawArray.length; i > 0; i--) {
            reversedArray[rawArray.length - i] = rawArray[i - 1];
        }
        return reversedArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = leftStack.array.length; i > 0; i--) {
            sb.append(leftStack.array[i - 1] == null ? "-" : leftStack.array[i - 1]).append(" ");
        }

        sb.append("|");

        for (int i = 0; i < rightStack.array.length; i++) {
            sb.append(" ").append(rightStack.array[i] == null ? "-" : rightStack.array[i]);
        }

        return sb.toString();
    }
}
