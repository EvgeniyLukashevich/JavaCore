package ru.geekbrains.seminar3_hw.models;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс, содержащий в себе массив рабочих, информацию об элементах которого можно выводить,
 * использую foreach, благодаря имплементации интерфейса Iterable и реализации метода iterator.
 */
public class WorkerArray implements Iterable<BaseWorker> {
    private BaseWorker[] workers;

    public WorkerArray(BaseWorker[] workers) {
        this.workers = workers;
    }

    @Override
    public Iterator<BaseWorker> iterator() {
        return Arrays.asList(workers).iterator();
    }
}
