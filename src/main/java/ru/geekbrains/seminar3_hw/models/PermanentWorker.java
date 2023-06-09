package ru.geekbrains.seminar3_hw.models;

/**
 * Класс рабочего с фиксированным месячным окладом, наследуемый от BaseWorker.
 */
public class PermanentWorker extends BaseWorker {
    private double fixedSalary;

    public PermanentWorker(String name) {
        this(name, 58500.75);
    }

    public PermanentWorker(String name, Double fixedSalary) {
        super(name);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double getMonthlySalary() {
        return fixedSalary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n(Оклад: %.2f)", fixedSalary);
    }
}
