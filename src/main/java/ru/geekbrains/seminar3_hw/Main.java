package ru.geekbrains.seminar3_hw;

import ru.geekbrains.seminar3_hw.models.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // а) - б) Заполнилняем массив базового типа работниками наследуемых типов
        // и выводим данные о каждом работнике, включая рассчитанную месячную выплату.
        BaseWorker[] workers = {
                new PermanentWorker("Иванов Иван Иванович"),
                new PermanentWorker("Петров Василий Николаевич", 45000.00),
                new HourlyWorker("Скайуокер Люк Вейдорович"),
                new HourlyWorker("Каноби Оби Ван", 299.99)
        };

        System.out.println("#####\nВывод неотсортированного массива:\n#####");
        for (BaseWorker worker : workers)
            System.out.println(worker.toString());


        // в) Используя созданный класс-сортировщик, сортируем массив по величине месячной выплаты
        // и снова выводим данные.
        Arrays.sort(workers, new WorkerComparator());

        System.out.println("\n#####\nВывод массива, отсортированного по месячной выплате:\n#####");
        for (BaseWorker worker : workers)
            System.out.println(worker.toString());


        // г) Создадим обюъект класса WorkerArray и передадим в него новый массив работников.
        // Убедимся, что можем перебирать элементы массива из класса WorkerArray с помощью foreach
        // и имеем доступ к данным элементов массива.
        BaseWorker[] workers2 = {
                new PermanentWorker("Моспан Екатерина Сергеевна", 70000.00),
                new HourlyWorker("Литвинчук Александра Владимировна", 199.99)
        };
        WorkerArray workerArray = new WorkerArray(workers2);

        System.out.println("\n#####\nВывод массива, содержащегося в классе WorkerArray с использованием foreach:\n#####");
        for (BaseWorker worker : workerArray)
            System.out.println(worker.toString());

    }
}
