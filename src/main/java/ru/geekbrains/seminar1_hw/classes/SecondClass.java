package ru.geekbrains.seminar1_hw.classes;

import java.util.Random;

/**
 * Логики в приложении совсем мало, поэтому в этом классе
 * будут лежать константы, их геттеры и метод генерации числа.
 */
public class SecondClass {
    private final Integer LOWER_LIMIT = 1;
    private final Integer UPPER_LIMIT = 1000;
    private final Integer TRIES_NUMBER = 10;

    /**
     * Метод случайной генерации числа в пределах нижней и верхней границ.
     *
     * @return случайно сгенерированное число.
     */
    public Integer numberGenerate() {
        Random random = new Random();
        return random.nextInt(this.LOWER_LIMIT, this.UPPER_LIMIT + 1);
    }

    /**
     * Метод возвращающий нижнюю возможную границу загадываемого числа.
     *
     * @return нижняя возможная граница загадываемого числа.
     */
    public Integer getLowerLimit() {
        return this.LOWER_LIMIT;
    }

    /**
     * Метод возвращающий верхнюю возможную границу загадываемого числа.
     *
     * @return верхняя возможная граница загадываемого числа.
     */
    public Integer getUpperLimit() {
        return this.UPPER_LIMIT;
    }

    /**
     * Метод возвращающий количество попыток, отведенное на возможность угадать число.
     *
     * @return количество попыток.
     */
    public Integer getTriesNumber() {
        return this.TRIES_NUMBER;
    }
}
