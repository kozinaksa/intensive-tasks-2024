package com.walking.intensive.chapter2.task8;

import java.util.Arrays;

/**
 * Добираясь в школу на трамвае Вова проверяет, является ли купленный билет счастливым.
 * Если является, то нужно загадать желание и съесть билетик.
 *
 * <p>Билет содержит 6 цифр, комбинации подбираются случайным образом от 000000 до 999999.
 *
 * <p>Билет считается счастливым, если сумма первых трех цифр равна сумме последних трех цифр.
 *
 * <p>Пример: 123411 – счастливый (1 + 2 + 3 == 4 + 1 + 1).
 *
 * <p>Реализуйте метод getHappyTicketChance(), который будет возвращать вероятность
 * выпадения счастливого билета.
 *
 * <p>P.S. Вероятность – это отношение благоприятных исходов к числу всех исходов.
 * Вероятность не может принимать значение больше 1.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task8 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static double getHappyTicketChance() {
        int[] halfRanks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] combinations = new int[14];

        for (int i = 0; i < 14; i++) {
            combinations[i] = getSumRanks(halfRanks, i) + i + 1;
            if (i >= 10) {
                combinations[i] -= combinations[i - 10] * 3;
            }
        }

        for (int i = 0; i < combinations.length; i++) {
            combinations[i] = (int) Math.pow(combinations[i], 2);
        }

        return (double) (Arrays.stream(combinations).sum() * 2) / (999999 + 1);
    }

    static int getSumRanks(int[] ranks, int count) {
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += ranks[i];
        }

        return sum;
    }
}
