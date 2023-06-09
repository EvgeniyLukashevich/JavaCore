package ru.geekbrains.seminar3_hw.models;

/**
 * Класс рабочего с почасовой оплатой, наследуемый от класса BaseWorker.
 */
public class HourlyWorker extends BaseWorker {
    private double hourlySalary;

    public HourlyWorker(String name) {
        this(name, 400.33);
    }

    public HourlyWorker(String name, double hourlySalary) {
        super(name);
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double getMonthlySalary() {
        return hourlySalary * 20.8 * 8;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n(Такса за час: %.2f)", hourlySalary);
    }
}
