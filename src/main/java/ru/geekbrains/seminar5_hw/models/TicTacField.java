package ru.geekbrains.seminar5_hw.models;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class TicTacField {

    private int[] fieldState;

    public TicTacField(int[] fieldState) {
        this.fieldState = fieldState;
    }


    /**
     * Метод кодирующий массив из 9 чисел в массив байт.
     *
     * @return массив байтов размером 3, содержащий закодированные данные игрового поля TicTacToe
     */
    private byte[] coder() {
        int encodedData = 0;
        // запускаем цикл по каждому элементу входного массива
        for (int i = 0; i < fieldState.length; i++) {
            // добавляем очередной элемент в закодированные данные,
            // используя поразрядную операцию ИЛИ с присваиванием
            encodedData |= fieldState[i] << (2 * i);
            // каждое значение элемента массива шифруется 2 битами
            // и записывается в закодированные данные с помощью операции "или" с присваиванием
        }

        // создаем байтовый массив, используя объект ByteBuffer и закодированные данные
        byte[] bytes = ByteBuffer.allocate(4).putInt(encodedData).array();
        // создаем байтовый массив (размером 3 байта) для хранения результатов
        byte[] result = new byte[3];
        // копируем 3 байта из закодированных данных в результирующий массив, начиная с первого байта
        System.arraycopy(bytes, 1, result, 0, 3);

        System.out.println("Данные успешно закодированы.");
        return result;

    }


    /**
     * Метод, раскодирующий массив из 3 байт в массив целых чисел.
     *
     * @param encodedBytes массив байтов размером 3, содержащий закодированные данные игрового поля TicTacToe
     */
    private void decoder(byte[] encodedBytes) {
        int[] arr = new int[9];
        byte[] fullBytes = new byte[4];
        System.arraycopy(encodedBytes, 0, fullBytes, 1, 3);
        ByteBuffer buffer = ByteBuffer.wrap(fullBytes);

        int encodedData = buffer.getInt();
        for (int i = 0; i < arr.length; i++)
            arr[i] = (encodedData >>> (2 * i)) & 0b11;

        fieldState = arr;
        System.out.println("Данные успешно раскодированы.");
    }

    /**
     * Записывает массив байт в файл.
     *
     * @param filename имя файла, в который будут записаны данные
     * @throws IOException если при записи данных в файл произошла ошибка
     */
    public void writeToFile(String filename) throws IOException {
        try (FileOutputStream output = new FileOutputStream(filename)) {
            output.write(coder());
        }
        System.out.println("Данные успешно записаны в файл " + filename);
    }

    /**
     * Считывает массив байт нужного размера из файла.
     *
     * @param filename имя файла, из которого должны быть прочитаны данные
     * @throws IOException если при чтении данных из файла произошла ошибка
     */
    public void readFromFile(String filename) throws IOException {
        byte[] byteArray = new byte[3];
        try (FileInputStream input = new FileInputStream(filename)) {
            input.read(byteArray);
        }
        decoder(byteArray);
        System.out.println("Данные из файла " + filename + " успешно считаны");
    }

    /**
     * Рисует поле
     */
    public void fieldPrint() {
        for (int i = 1; i <= 9; i++) {
            if (i % 3 == 0)
                System.out.println("|" + fieldState[i - 1] + "|");
            else
                System.out.print("|" + fieldState[i - 1]);
        }
    }
}