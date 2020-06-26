package hw1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        method1(3, 3);

        int[] a = {4, 6, 8};
        method2(a);
        method3(a);
    }

    //Возведение в степень
    //O(n), т.к. итерации отсутствуют
    public static void method1(int number, int degreeOf) {
        System.out.println("Число " + number + " в степени " + degreeOf + " = " + Math.pow(number, degreeOf));
    }

    //Поиск минимального элемента в массиве
    // O(n), т.к. итерации отсутствуют
    public static void method2(int[] a) {
        Arrays.sort(a);
        System.out.println("Минимальный элемент: " + a[0]);
    }

    //Нахождение среднего арифметического массива
    // O(n), т.к. итерации отсутствуют, сделано при помощи стримов
    public static void method3(int[] numbers) {
        double average = IntStream.of(numbers).average().getAsDouble();
        System.out.println("Среднее арифметическое массива: " + average);
    }
}