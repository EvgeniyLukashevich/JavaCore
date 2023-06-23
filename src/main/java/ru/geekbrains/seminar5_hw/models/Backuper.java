package ru.geekbrains.seminar5_hw.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Класс, помогающий с созданием резервных копий файлов
 */
public class Backuper {
    private final File backupDirectory;

    /**
     * Конструктор класса Backuper, не требующий аргументов
     * (директорией для резевных копий файлов по умолчанию станет './backup')
     */
    public Backuper() {
        this(new File("./backup"));
    }

    /**
     * Конструктор класса Backuper, принимающий желаемую директорию для резервных копий файлов в качестве аргумента
     *
     * @param backupDirectory директория для резервных копий файлов
     */
    public Backuper(File backupDirectory) {
        this.backupDirectory = backupDirectory;
    }

    /**
     * Метод, проверяющий существование директории для резевных копий файлов
     * и, при необходимости, создающий такую директорию
     */
    private void backupDirectoryCreate() {
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
            System.out.println("Директория для резервного копирования создана.");
        }
    }

    /**
     * Метод копирования файлов
     *
     * @param directory директория, файлы из которой будут скопированы
     * @throws IOException
     */
    public void letsBackup(File directory) throws IOException {
        // Очищаем директорию перед копированием
        clearBackupDirectory();
        // Если директории не существует, создаем её
        backupDirectoryCreate();
        File[] files = directory.listFiles();

        // Копируем файлы из исходной директории в директорию для резервных копий
        for (File file : files)
            if (file.isFile()) {
                Files.copy(file.toPath(), new File(backupDirectory + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Резервная копия файла " + file.getName() + " успешно создана.");
            }
    }

    /**
     * Метод, очищающий директорию для резервных копий файлов
     *
     * @throws IOException
     */
    private void clearBackupDirectory() throws IOException {
        // Проверяем, что директория бэкапа существует и является директорией, а не файлом
        if (backupDirectory.exists() && backupDirectory.isDirectory()) {
            File[] files = backupDirectory.listFiles();

            // Удаляем каждый файл в списке
            for (File file : files)
                if (file.isFile()) Files.delete(file.toPath());
            System.out.println("Директория для резервного копирования очищена.");

        } else System.out.println("Директория для резервного копирования не найдена.");
    }


}
