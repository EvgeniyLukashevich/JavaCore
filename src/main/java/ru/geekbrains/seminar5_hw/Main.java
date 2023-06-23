package ru.geekbrains.seminar5_hw;

import ru.geekbrains.seminar5_hw.models.Backuper;
import ru.geekbrains.seminar5_hw.models.TicTacField;
import ru.geekbrains.seminar5_hw.models.Tree;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // Задание № 1
        Backuper backuper = new Backuper();
        backuper.letsBackup(new File("src/main/java/ru/geekbrains/seminar5_hw"));


        // Задание № 2
        System.out.println("\n# # # # # # ЗАДАНИЕ № 2 # # # # # #\n");
        Tree tree = new Tree();
        tree.print(new File("."), "", true);


        // Задание № 3
        System.out.println("\n\n# # # # # # ЗАДАНИЕ № 3 # # # # # #\n");
        int[] values = {0, 2, 1, 3, 1, 0, 2, 3, 1};
        TicTacField field = new TicTacField(values);

        System.out.println("Исходные значения:");
        field.fieldPrint();

        field.writeToFile("src/main/java/ru/geekbrains/seminar5_hw/task3.bin");
        File task3File = new File("src/main/java/ru/geekbrains/seminar5_hw/task3.bin");
        System.out.println("Размер файла: " + task3File.length() + " байт\n");

        field.readFromFile("src/main/java/ru/geekbrains/seminar5_hw/task3.bin");

        System.out.println("Раскодированные значения:");
        field.fieldPrint();

    }
}
