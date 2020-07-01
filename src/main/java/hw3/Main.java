package hw3;

public class Main {
    public static void main(String[] args) {
        reverseString("Привет");
    }

    //    1. Создать программу, которая переворачивает вводимые строки (читает справа налево).
    public static String reverseString(String inputString) {
        String result = "";
        for (int i = 0; i < inputString.length(); i++) {
            result = inputString.charAt(i) + result;
        }
        System.out.println(result);
        return result;
    }
}
