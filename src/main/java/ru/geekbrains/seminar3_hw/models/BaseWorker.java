package ru.geekbrains.seminar3_hw.models;

/**
 * Базовый абстрактный класс рабочего.
 */
public abstract class BaseWorker {
    private String name;

    public BaseWorker(String name) {
        this.name = name;
    }

    public abstract double getMonthlySalary();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("\nИмя: %s\nВыплатить за месяц: %.2f", name, getMonthlySalary());
    }

}
