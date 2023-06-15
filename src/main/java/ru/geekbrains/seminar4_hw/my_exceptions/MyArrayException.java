package ru.geekbrains.seminar4_hw.my_exceptions;

/**
 * Базовый абстрактный класс наших исключений.
 */
public abstract class MyArrayException extends Exception {
    protected int x;
    protected int y;

    public MyArrayException(String message, int x, int y) {
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
