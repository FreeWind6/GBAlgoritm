package hw6;

import java.util.Random;

/**
 * 1. Создать и запустить программу для построения двоичного дерева. В цикле построить
 * двадцать деревьев с глубиной в 6 уровней. Данные, которыми необходимо заполнить узлы деревьев,
 * представляются в виде чисел типа int. Число, которое попадает в узел, должно генерироваться
 * случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */
public class Main {
    private static final int TREE_COUNT = 20;
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    private static final int TREE_HEIGHT = 6;

    public static void main(String[] args) {
        Random random = new Random();
        int bound = MAX_VALUE - MIN_VALUE + 1;
        int notBalancedCount = 0;

        for (int i = 0; i < TREE_COUNT; i++) {
            Tree<Integer> tree = new Tree<>(TREE_HEIGHT);
            do {
                try {
                    tree.add(random.nextInt(bound) + MIN_VALUE);
                } catch (IndexOutOfBoundsException ex) {
                    break;
                }
            } while (true);
            if (!tree.isBalanced()) {
                notBalancedCount++;
            }
        }
        System.out.printf("Несбалансированных деревьев: %d из %d", notBalancedCount, TREE_COUNT);
    }
}
