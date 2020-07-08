package hw5;

public class Ferz {
    /**
     * Размер
     */
    private static int size = 8;

    /**
     * Доска
     */
    private static int[][] desk = new int[size][size];

    public static void main(String[] args) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                desk[i][j] = 0;
            }
        }
        tryFerz(0);
        //Вывод на экран
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (desk[i][j] == -1) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private static boolean tryFerz(int i) {
        boolean result = false;
        for (int j = 0; j < size; ++j) {
            if (desk[i][j] == 0) {
                setFerz(i, j);
                if (i == size - 1) {
                    result = true;
                } else {
                    if (!(result = tryFerz(i + 1))) {
                        resetFerz(i, j);
                    }
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Убираем ферзя с доски
     *
     * @param i координата
     * @param j координата
     */
    private static void resetFerz(int i, int j) {
        for (int x = 0; x < size; ++x) {
            --desk[x][j];
            --desk[i][j];
            int foo;
            foo = j - i + x;
            if (foo >= 0 && foo < size) {
                --desk[x][foo];
            }
            foo = j + i - x;
            if (foo >= 0 && foo < size) {
                --desk[x][foo];
            }
        }
        desk[i][j] = 0;
    }

    /**
     * Устанавливаем позицию ферзя
     *
     * @param i координата
     * @param j координата
     */
    private static void setFerz(int i, int j) {
        for (int x = 0; x < size; ++x) {
            ++desk[x][j];
            ++desk[i][j];
            int foo;
            foo = j - i + x;
            if (foo >= 0 && foo < size) {
                ++desk[x][foo];
            }
            foo = j + i - x;
            if (foo >= 0 && foo < size) {
                ++desk[x][foo];
            }
        }
        desk[i][j] = -1;
    }
}
