package ru.geekbrains.seminar1_hw.start_point;

import ru.geekbrains.seminar1_hw.classes.FirstClass;
import ru.geekbrains.seminar1_hw.classes.SecondClass;

/**
 * В отсутствие презентера или контроллера, собираем приложение,
 * непосредственно, в Мейне.
 * Собираем таким образом, чтобы у пользователя была возможность
 * угадать случайное число от 1 до 1000 за 10 попыток.
 * При этом программа будет подсказывать, меньше или больше
 * загаданное число, чем предлагаемое пользователем.
 */
public class Main {
    public static void main(String[] args) {

        FirstClass view = new FirstClass();
        SecondClass model = new SecondClass();

        Integer number = model.numberGenerate();
        view.startMessage(
                model.getLowerLimit(),
                model.getUpperLimit(),
                model.getTriesNumber()
        );
        boolean bingo = false;

        for (int i = 0; i < model.getTriesNumber(); i++) {
            Integer userNumber = view.inputNumber(i + 1);

            if (userNumber.equals(number)) {
                view.winMessage(number, i + 1);
                bingo = true;
                break;
            } else
                view.hintMessage(number, userNumber);
        }

        if (!bingo)
            view.loseMessage(number);
    }
}
