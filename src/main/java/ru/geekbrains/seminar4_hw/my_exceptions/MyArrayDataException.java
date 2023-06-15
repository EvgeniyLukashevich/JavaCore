package ru.geekbrains.seminar4_hw.my_exceptions;

/**
 * Класс исключений некорректного значения элемента массива.
 */
public class MyArrayDataException extends MyArrayException {
    String value;

    /**
     * Конструктор класса исключений некорректного значения элемента массива.
     *
     * @param message сообщение об ошибке.
     * @param x       внешний индекс элемента.
     * @param y       внутренний индекс элемента.
     * @param value   значение элемента.
     */
    public MyArrayDataException(String message, int x, int y, String value) {
        super(message, x, y);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
