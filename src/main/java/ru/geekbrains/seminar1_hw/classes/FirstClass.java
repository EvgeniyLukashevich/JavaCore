package ru.geekbrains.seminar1_hw.classes;

import java.util.Scanner;

/**
 * Так как необходимо создать всего два "рабочих" класса,
 * этот класс будет отвечать за ввод/вывод через консоль.
 * Что-то вроде усеченного ViewConsole без наследования от
 * какого-нибудь базового View
 */
public class FirstClass {

    /**
     * Метод, запроса числа на ввод, указывая номер попытки ввода.
     *
     * @param tryNumber порядковый номер попытки ввода числа.
     * @return введенное число.
     */
    public Integer inputNumber(Integer tryNumber) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Попытка № %d: ", tryNumber);
        return scan.nextInt();
    }

    /**
     * Метод вывода в консоль стартового сообщения.
     *
     * @param lowerLimit  нижняя возможная граница загаданного числа.
     * @param upperLimit  верхняя возможная граница загаданного числа.
     * @param triesNumber количество возможных попыток угадать число.
     */
    public void startMessage(Integer lowerLimit, Integer upperLimit, Integer triesNumber) {
        System.out.printf("""
                        Загадано число от %d до %d.
                        У вас есть %d попыток, чтобы угадать это число. Удачи! ;)
                        """,
                lowerLimit, upperLimit, triesNumber
        );
    }

    /**
     * Метод вывода в консоль сообщения о победе.
     *
     * @param number      загаданное число.
     * @param triesNumber количество попыток, потребовавшихся, чтобы отгадать число.
     */
    public void winMessage(Integer number, Integer triesNumber) {
        System.out.printf("Поздравляю! Вы отгадали число %d за %d попыток.", number, triesNumber);
    }

    /**
     * Метод вывода в консоль сообщения о поражении.
     *
     * @param number загаданное число.
     */
    public void loseMessage(Integer number) {
        System.out.printf("Вам не повезло. Было загадано число %d.", number);
    }

    /**
     * Метод вывода в консоль сообщения-подсказки.
     *
     * @param number     загаданное число.
     * @param userNumber число, предложенное пользователем.
     */
    public void hintMessage(Integer number, Integer userNumber) {
        if (number > userNumber)
            System.out.println("Загаданное число больше.");
        else
            System.out.println("Загаданное число меньше.");
    }


}
