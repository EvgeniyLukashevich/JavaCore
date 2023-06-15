package ru.geekbrains.seminar4_hw.my_exceptions;

/**
 * Класс исключений некорректного размера массива.
 */
public class MyArraySizeException extends MyArrayException {

    /**
     * Конструктор класса исключений некорректного размера массива.
     *
     * @param message сообщение об ошибке.
     * @param x       размер внешней вложенности массива.
     * @param y       размер внутренней вложенности массива.
     */
    public MyArraySizeException(String message, int x, int y) {
        super(message, x, y);
    }

}
