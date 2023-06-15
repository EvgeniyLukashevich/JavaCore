package ru.geekbrains.seminar4_hw;

import ru.geekbrains.seminar4_hw.my_exceptions.MyArrayDataException;
import ru.geekbrains.seminar4_hw.my_exceptions.MyArraySizeException;

import java.util.Random;

public class Main {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {


        while (true) {
            String[][] myArray = generate2dArray(4, 4);

            // В случае полностью подходящего нам массива, прервём цикл.
            // В обратном случае будем отлавливать и обрабатывать исключения,
            // Пока не будет сгенерирован подходящий массив
            try {
                print2dArray(myArray);
                System.out.println("Сумма: " + arrayElementsSum(myArray) + "\n");
                break;

            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
                System.out.printf("Корректный размер: 4х4. Размер массива: %dx%d", e.getX(), e.getY());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
                System.out.printf("Значение элемента с индексом [%d][%d] = '%s'", e.getX(), e.getY(), e.getValue());
            }finally {
                System.out.println("\n\n# # # # # # # # # #\n");
            }
        }
    }


    /**
     * Метод создания и заполнения двумерного массива строк заданного размера.
     *
     * @param rowsCount    количество строк.
     * @param columnsCount количество столбцов.
     * @return заполненный двумерный массив.
     */
    private static String[][] generate2dArray(int rowsCount, int columnsCount) {
        // Добавил элемент неожиданности для более удобной проверки работы исключений.
        // В некоторых случаях будет генерироваться массив неподходящего для нас размера.
        int trickster = RANDOM.nextInt(4);
        if (trickster == 0)
            rowsCount++;
        if (trickster == 1)
            columnsCount++;

        String[][] newArray = new String[rowsCount][columnsCount];

        for (int i = 0; i < rowsCount; i++)
            for (int j = 0; j < columnsCount; j++)
                newArray[i][j] = String.valueOf(RANDOM.nextInt(10, 20));

        // В некоторых случаях рандомная ячейка массива примет неподходящее значение.
        if (trickster == 2)
            newArray[RANDOM.nextInt(rowsCount)][RANDOM.nextInt(columnsCount)] = "Hi";

        return newArray;
    }


    /**
     * Метод вывода двумерного массива.
     *
     * @param array двумерный массив.
     */
    private static void print2dArray(String[][] array) {
        for (String[] row : array) {
            for (String element : row)
                System.out.print(element + " ");
            System.out.println();
        }
        System.out.println();
    }


    /**
     * Метод сложения значений элементов массива, приведенных к инту.
     *
     * @param yourArray двумерный массив.
     * @return сумма элементов массива.
     * @throws MyArraySizeException в случае неподходящего размера массива.
     * @throws MyArrayDataException в случае неподходящего значения элемента массива.
     */
    private static int arrayElementsSum(String[][] yourArray) throws MyArraySizeException, MyArrayDataException {
        if (yourArray.length != 4 || yourArray[0].length != 4)
            throw new MyArraySizeException("Некорректный размер массива.", yourArray.length, yourArray[0].length);

        int result = 0;

        for (int i = 0; i < yourArray.length; i++)
            for (int j = 0; j < yourArray[i].length; j++) {
                if (!isNumber(yourArray[i][j]))
                    throw new MyArrayDataException("Некорректное значение элемента массива.", i, j, yourArray[i][j]);
                else
                    result += Integer.parseInt(yourArray[i][j]);
            }
        return result;
    }

    /**
     * Проверка возможности приведения строки к инту.
     *
     * @param str строка.
     * @return в случае прохождения проверки - истина, иначе - ложь.
     */
    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
