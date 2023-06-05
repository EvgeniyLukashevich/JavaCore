package ru.geekbrains.seminar2_hw;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final char HUMAN_MARK = '▲';
    private static final char AI_MARK = '●';
    private static final char EMPTY_CELL = '□';
    private static final int BINGO_COUNT = 4;
    private static final Scanner SCAN = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        Integer currentTurn = 0;
        while (true) {
            fieldInit();
            fieldPrint();
            while (true) {
                humanTurn();
                fieldPrint();
                currentTurn++;
                if (endGameCheck(HUMAN_MARK, currentTurn, "Поздравляю! Вы победили! :)"))
                    break;
                aiFoolishTurn();
                fieldPrint();
                currentTurn++;
                if (endGameCheck(AI_MARK, currentTurn, "Поздравляю! Вы проиграли! :)"))
                    break;
            }
            System.out.println("Повторим? (y - да)");
            if (!SCAN.next().equals("y"))
                break;
        }
    }

    /**
     * Метод инициализации игрового поля
     */
    private static void fieldInit() {
        fieldSizeX = 7;
        fieldSizeY = 5;

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++)
            for (int y = 0; y < fieldSizeY; y++)
                field[x][y] = EMPTY_CELL;
    }

    /**
     * Метод отрисовки игрового поля
     */
    private static void fieldPrint() {
        // Рисуем шапку
        System.out.print("+");
        for (int i = 1; i <= fieldSizeX; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        // Во внешнем цикле проставляем номер строки,
        // во внутреннем - заполняем строку символами из нашего массива (игрового поля)
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print("|" + field[j][i]);
            }
            System.out.print("|");
            System.out.println();
        }

        // Рисуем подвал
        for (int j = 0; j <= fieldSizeX; j++)
            System.out.print("==");
        System.out.println();
    }

    /**
     * Метод проверки ячейки на валидность
     *
     * @param x координата по горизонтали
     * @param y координата по вертикали
     * @return истина/ложь в случае, если проверка пройдена/не пройдена
     */
    private static boolean validCellCheck(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Метод проверки, является ли ячейка пустой
     *
     * @param x координата по горизонтали
     * @param y координата по вертикали
     * @return истина/ложь в случае, если проверка пройдена/не пройдена
     */
    private static boolean emptyCellCheck(int x, int y) {
        return field[x][y] == EMPTY_CELL;
    }

    /**
     * Метод обработки хода игрока
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты хода через пробел: ");
            x = SCAN.nextInt() - 1;
            y = SCAN.nextInt() - 1;
        } while (!validCellCheck(x, y) || !emptyCellCheck(x, y));
        field[x][y] = HUMAN_MARK;
    }

    /**
     * Метод "невнимательного" хода компьютера
     */
    private static void aiFoolishTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!emptyCellCheck(x, y));
        field[x][y] = AI_MARK;
    }

    /**
     * Метод проверки состояния игры на предмет победы одного из играющих (человек/комп)
     *
     * @param mark метка, отмечающая ход
     * @return истина в случае победы, ложь в случае отсутсвия победы
     */
    private static boolean winCheck(char mark) {
        return horizontalWinCheck(mark) || verticalWinCheck(mark) || diagonalWinCheck(mark);
    }

    /**
     * Метод проверки состояния игры на предмет ничьи
     *
     * @param currentTurn порядковый номер текущего хода
     * @return истина в случае ничьей, ложь в случае отсутсвия ничьей
     */
    private static boolean drawCheck(Integer currentTurn) {
        return currentTurn == fieldSizeX * fieldSizeY;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param mark        метка, отмечающая ход
     * @param currentTurn порядковый номер текущего хода
     * @param message     поздравительное сообщение
     * @return истина, если игра окончена, ложь - игра продолжается
     */
    private static boolean endGameCheck(char mark, Integer currentTurn, String message) {
        if (winCheck(mark)) {
            System.out.println(message);
            return true;
        } else if (drawCheck(currentTurn)) {
            System.out.println("Игра закончена, и в ней никто не проиграл :)");
            return true;
        } else {
            return false;
        }
    }

    private static boolean horizontalWinCheck(char mark) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                int comboCount = 1;
                for (int k = 1; k <= BINGO_COUNT && i + k < fieldSizeX; k++)
                    if (mark == field[i][j] && mark == field[i + k][j])
                        comboCount++;
                    else
                        break;
                if (comboCount == BINGO_COUNT)
                    return true;
            }
        }
        return false;
    }

    private static boolean verticalWinCheck(char mark) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                int comboCount = 1;
                for (int k = 1; k <= BINGO_COUNT && k + j < fieldSizeY; k++)
                    if (mark == field[i][j] && mark == field[i][j + k])
                        comboCount++;
                    else
                        break;
                if (comboCount == BINGO_COUNT)
                    return true;
            }
        }
        return false;
    }

    private static boolean diagonalWinCheck(char mark) {
        for (int i = 0; i < fieldSizeX; i++)
            for (int j = 0; j < fieldSizeY; j++) {
                int comboCountForward = 1;
                for (int k = 1; k <= BINGO_COUNT && i + k < fieldSizeX && j + k < fieldSizeY; k++) {
                    if (mark == field[i][j] && mark == field[i + k][j + k])
                        comboCountForward++;
                    else
                        break;
                    if (comboCountForward == BINGO_COUNT)
                        return true;
                }
                int comboCountBack = 1;
                for (int k = 1; k <= BINGO_COUNT && i - k >= 0 && j + k < fieldSizeY; k++) {
                    if (mark == field[i][j] && mark == field[i - k][j + k])
                        comboCountBack++;
                    else
                        break;
                    if (comboCountBack == BINGO_COUNT)
                        return true;
                }
            }
        return false;
    }


}
