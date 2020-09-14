package ru.geekbrains.lesson3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    /*
    Полностью разобраться с кодом;
    Переделать проверку победы, чтобы она не была реализована просто набором условий.
    * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
    *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока, и пытаться выиграть сам.
     */
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final char EMPTY_DOT = '.';
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final int MAX_X = 5;
    private static final int MAX_Y = 5;
    private static final int COUNT_WIN = 4;


    private static char[][] field;


    public static void main(String[] args) {
        initialField();
        do {

            humanMove();
            printField();
            if (isThereWinner(HUMAN_DOT)) {
                System.out.println("Человек победил машину!");
                break;
            }
            if (isFieldEnded()) {
                System.out.println("Игра закончилась ничьей!");
                break;
            }

            aiMove();
            printField();
            if (isThereWinner(AI_DOT)) {
                System.out.println("Машины победели!");
                break;
            }
            if (isFieldEnded()) {
                System.out.println("Игра закончилась ничьей!");
                break;
            }

        } while (true);

    }

    //check winner
    private static boolean isThereWinner(char dot) {
        int count;
        for (int x = 0; x < MAX_X; x++) {
            count = 0;
            for (int y = 0; y < MAX_Y; y++) {
                if (field[y][x] == dot)
                    count++;
                else if (count > 0)
                    break;
            }
            if (count == COUNT_WIN) return true;
        }

        for (int y = 0; y < MAX_Y; y++) {
            count = 0;
            for (int x = 0; x < MAX_X; x++) {
                if (field[y][x] == dot)
                    count++;
                else if (count > 0)
                    break;

            }
            if (count == COUNT_WIN) return true;
        }


        // check diagonal
        for (int i = 0; i <= MAX_Y - COUNT_WIN; i++) {
            for (int j = 0; j <= MAX_X - COUNT_WIN; j++) {
                count = 0;
                for (int m = 0, k = 0; m < MAX_Y - i && k < MAX_X - j; m++, k++) {
                    if (field[i + m][j + k] == dot)
                        count++;
                    else if (count > 0) break;
                }
                if (count == COUNT_WIN) return true;

            }
        }

        // check reverse diagonal
        for (int i = 0; i <= MAX_Y - COUNT_WIN; i++) {
            for (int j = 0; j <= MAX_X - COUNT_WIN; j++) {
                count = 0;
                for (int m = 0, k = 0; m < MAX_Y - i && k < MAX_X - j; m++, k++) {
                    if (field[i + m][MAX_X - j - k - 1] == dot)
                        count++;
                    else if (count > 0) break;
                }
                if (count == COUNT_WIN) return true;

            }
        }


        return false;
    }

    //human step
    private static void humanMove() {
        int x, y;
        do {
            System.out.print("Введите координаты точки x y через пробел >");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isInAllowedRange(x, y) || !isEmptyPlace(x, y));

        field[y][x] = HUMAN_DOT;

    }


    //ai step
    // Когда я смотрю на свой код, я плачу!!!(((
    private static void aiMove() {
        // проверка всех возможных комбинаций и сравнение с выигрышным кол-вом. если есть такие, закрыть следующий ход

        // проверка комбинаций по оси x
        for (int y = 0; y < MAX_Y; y++) {
            int count = 0;
            for (int x = 0; x < MAX_X; x++) {
                if (field[y][x] == HUMAN_DOT) {
                    count++;
                    if (count >= COUNT_WIN - 2) {
                        for (int i = x - 1; i >= 0; i--) {
                            if (isEmptyPlace(i, y)) {
                                field[y][i] = AI_DOT;
                                return;
                            } else if (field[y][i] == AI_DOT) break;
                        }

                        if (x + 1 < MAX_X && isEmptyPlace(x + 1, y)) {
                            field[y][x + 1] = AI_DOT;
                            return;
                        } else if (x - count >= 0 && isEmptyPlace(x - count, y)) {
                            field[y][x - count] = AI_DOT;
                            return;
                        }

                    }
                } else if (count > 0 && (x + 1 < MAX_X && field[y][x + 1] == EMPTY_DOT || x + 1 == MAX_X)) break;
            }
        }

        // проверка по оси y
        for (int x = 0; x < MAX_X; x++) {
            int count = 0;
            for (int y = 0; y < MAX_Y; y++) {
                if (field[y][x] == HUMAN_DOT) {
                    count++;
                    if (count >= COUNT_WIN - 2) {
                        for (int i = y - 1; i >= 0; i--) {
                            if (isEmptyPlace(x, i)) {
                                field[i][x] = AI_DOT;
                                return;
                            } else if (field[i][x] == AI_DOT) break;
                        }

                        if (y + 1 < MAX_Y && isEmptyPlace(x, y + 1)) {
                            field[y + 1][x] = AI_DOT;
                            return;
                        } else if (y - count >= 0 && isEmptyPlace(x, y - count)) {
                            field[y - count][x] = AI_DOT;
                            return;
                        }

                    }
                } else if (count > 0 && (y + 1 < MAX_Y && field[y + 1][x] == EMPTY_DOT || y + 1 == MAX_Y)) break;
            }
        }

        //Особенно тут
        // проверка по диагонали
        int count = 0;
        for (int i = 0; i <= MAX_Y - COUNT_WIN; i++) {
            for (int j = 0; j <= MAX_X - COUNT_WIN; j++) {
                count = 0;
                for (int m = 0, k = 0; m < MAX_Y - i && k < MAX_X - j; m++, k++) {
                    if (field[i + m][j + k] == HUMAN_DOT) {
                        count++;
                        if (count >= COUNT_WIN - 2) {
                            for (int l = i + m - 1; l >= 0; l--) {
                                if (l - i + j >= 0 && isEmptyPlace(l - i + j, l)) {
                                    field[l][l - i + j] = AI_DOT;
                                    return;
                                }
                            }
                            if (i + m + 1 < MAX_Y && j + k + 1 < MAX_X && isEmptyPlace(j + k + 1, i + m + 1)) {
                                field[i + m + 1][j + k + 1] = AI_DOT;
                                return;
                            }
                        }

                    } else if (count > 0 && (i + m + 1 < MAX_Y && j + k + 1 < MAX_X && field[i + m + 1][j + k + 1] == EMPTY_DOT || (i + m + 1 == MAX_Y || j + k + 1 == MAX_X)))
                        break;
                }
            }
        }

        // Проверка обратной диагонали
        // Не работает, лучше поберечь глаза)
        count = 0;
        for (int i = 0; i <= MAX_Y - COUNT_WIN; i++) {
            for (int j = 0; j <= MAX_X - COUNT_WIN; j++) {
                count = 0;
                for (int m = 0, k = 0; m < MAX_Y - i && k < MAX_X - j; m++, k++) {
                    if (field[i + m][MAX_X - j - k - 1] == HUMAN_DOT) {
                        count++;
                        if (count >= COUNT_WIN - 2) {
                            int x = i + m;
                            int y = MAX_X - j - k - 1;
                            for (int l = 0; l < y; l++) {
                                if (isEmptyPlace(x - l, y + l)) {
                                    field[y + l][x - l] = AI_DOT;
                                    return;
                                }
                            }
                        }

                    } else if (count > 0 && (i + m + 1 < MAX_Y && j + k + 1 < MAX_X && field[i + m + 1][j + k + 1] == EMPTY_DOT || (i + m + 1 == MAX_Y || j + k + 1 == MAX_X)))
                        break;
                }
            }
        }


        // Рандомный ход, если не надо защищаться
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(MAX_X);
            y = random.nextInt(MAX_Y);
        } while (!isInAllowedRange(x, y) || !isEmptyPlace(x, y));

        field[y][x] = AI_DOT;

        System.out.println("AI move");

    }


    //check end field
    private static boolean isFieldEnded() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    //check x,y for allowed values
    private static boolean isInAllowedRange(int x, int y) {
        return x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y;
    }

    //check point is empty
    private static boolean isEmptyPlace(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    //initial field
    private static void initialField() {
        field = new char[MAX_Y][MAX_X];
        for (int i = 0; i < field.length; i++) {
            Arrays.fill(field[i], EMPTY_DOT);
        }
    }

    //print field
    private static void printField() {
        System.out.printf("%3c", ' ');
        for (int i = 1; i <= field.length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int y = 0; y < field.length; y++) {
            System.out.printf("%3d", y + 1);
            for (int x = 0; x < field[y].length; x++) {
                System.out.printf("%3c", field[y][x]);
            }
            System.out.println();


        }
    }

}
