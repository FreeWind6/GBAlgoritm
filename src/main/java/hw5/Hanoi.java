package hw5;

public class Hanoi {
    public static void main(String[] args) {
        int count = 3;
        move("1", "2", "3", count);
    }

    public static void move(String a, String b, String c, int count) {

        if (count == 1) {
            System.out.println("Переложить " + a + " на " + b);
        } else {
            move(a, c, b, count - 1);
            System.out.println("Переложить " + a + " на " + b);
            move(c, b, a, count - 1);
        }
    }
}
