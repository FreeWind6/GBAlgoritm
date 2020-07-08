package hw5;

public class Queen {
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
        tryQueen(0);
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

    private static boolean tryQueen(int i) {
        boolean result = false;
        for (int j = 0; j < size; ++j) {
            if (desk[i][j] == 0) {
                setQueen(i, j);
                if (i == size - 1) {
                    result = true;
                } else {
                    if (!(result = tryQueen(i + 1))) {
                        resetQueen(i, j);
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
     * Убираем королеву с доски
     *
     * @param i координата
     * @param j координата
     */
    private static void resetQueen(int i, int j) {
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
     * Устанавливаем позицию королевы
     *
     * @param i координата
     * @param j координата
     */
    private static void setQueen(int i, int j) {
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
