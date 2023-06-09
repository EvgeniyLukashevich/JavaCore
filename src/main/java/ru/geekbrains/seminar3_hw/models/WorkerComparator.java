package ru.geekbrains.seminar3_hw.models;

import javafx.concurrent.Worker;

import java.util.Comparator;

/**
 * Класс, позволяющий сортировать объекты типа BaseWorker,
 * благодаря имплементированию интерфейся Comparator и реализации метода compare.
 * В нашем случае сравнение и сортировка будет происходить по величине месячной выплаты работнику.
 */
public class WorkerComparator implements Comparator<BaseWorker> {
    @Override
    public int compare(BaseWorker o1, BaseWorker o2) {
        return Double.compare(o1.getMonthlySalary(), o2.getMonthlySalary());
    }
}
