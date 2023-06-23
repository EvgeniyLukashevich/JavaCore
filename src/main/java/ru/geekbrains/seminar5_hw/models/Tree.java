package ru.geekbrains.seminar5_hw.models;

import java.io.File;


public class Tree {

    /**
     * Метод, выводящий иерархическое дерево файлов/директорий
     *
     * @param startingDirectory - директория начала отрисовки дерева
     * @param indent            отступ при старте отрисовки
     * @param isLast            переменная, определяющая, является ли директория/файл последним вложением
     */
    public void print(File startingDirectory, String indent, boolean isLast) {
        // Блок отрисовки
        System.out.print(indent);
        if (isLast) {
            System.out.print("└──");
            indent += "    ";
        } else {
            System.out.print("├──");
            indent += "│   ";
        }
        System.out.println(startingDirectory.getName());

        // Если текущий файл - директория, обходим все её поддиректории и файлы
        if (startingDirectory.isDirectory()) {
            File[] files = startingDirectory.listFiles();
            if (files != null && files.length > 0) {

                // Определяем, сколько в текущей директории вложений
                int subFilesCount = 0;
                for (File subFile : files)
                    subFilesCount++;

                // Обходим все вложения, на каждой итерации рекурсивно вызывая функцию
                // с текущим файлом или папкой в качестве первого аргумента,
                // соответствующего отступа - в качестве второго,
                // и сравнения текущей позиции файла/папки с общим количеством-1 - в качестве последнего
                int subFilesCurrent = 0;
                for (File subFile : files) {
                    print(subFile, indent, subFilesCurrent == subFilesCount - 1);
                    subFilesCurrent++;
                }
            }
        }
    }
}