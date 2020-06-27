package hw2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        insert(1, 8);
        deleteIndex(2);
        deleteValue(2);
        deleteAll();
        shellSort();
        countingSort();
    }

    public static void insert(int index, int value) {
        int[] mas = {0, 1, 2, 3, 4};
        int[] temp = new int[mas.length + 1];
        temp[index] = value;
        System.arraycopy(mas, 0, temp, 0, index);
        System.arraycopy(mas, index, temp, index + 1, mas.length - index);
        System.out.println(Arrays.toString(temp));
    }

    public static void deleteIndex(int index) {
        int[] mas = {0, 1, 2, 3, 4};
        if (index >= mas.length)
            throw new ArrayIndexOutOfBoundsException(index);
        int[] temp = new int[mas.length - 1];
        System.arraycopy(mas, 0, temp, 0, index);
        System.arraycopy(mas, index + 1, temp, index, mas.length - index - 1);

        System.out.println(Arrays.toString(temp));
    }

    public static void deleteValue(int value) {
        int[] mas = {0, 1, 2, 3, 4};
        boolean temp = false;
        int tempInt = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == value) {
                temp = true;
                tempInt = i;
                break;
            } else {
                temp = false;
            }
        }
        if (temp == true) {
            deleteIndex(tempInt);
        } else {
            System.out.println("Число не найдено");
        }
    }

    public static void deleteAll() {
        int[] mas = {0, 1, 2, 3, 4};
        mas = new int[mas.length];
        System.out.println(Arrays.toString(mas));
    }

    //продвинутый вариант пузырьковой сортировки(писали в институте), сортировка Шелла
    public static void shellSort() {
        int[] mas = {88, 55, 22222, 33, 44};
        int s;
        for (int i = mas.length / 2; i > 0; i /= 2) {
            for (int j = i; j < mas.length; j++) {
                int temp = mas[j];
                for (s = j; s >= i && mas[s - i] > temp; s -= i) {
                    mas[s] = mas[s - i];
                }
                mas[s] = temp;
            }
        }
        System.out.println(Arrays.toString(mas));
    }

    //сортировка подсчётом, знаю поскольку писал в институте
    public static void countingSort() {
        int[] mas = {88, 55, 55, 22222, 33, 44, 88};
        int maxElement = Arrays.stream(mas).max().getAsInt();
        int numCounts[] = new int[maxElement + 1];
        for (int num : mas) {
            numCounts[num]++;
        }
        int[] sortedArray = new int[mas.length];
        int currentSortedIndex = 0;
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        System.out.println(Arrays.toString(sortedArray));
    }
}
