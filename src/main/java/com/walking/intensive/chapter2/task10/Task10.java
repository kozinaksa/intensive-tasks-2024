package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        System.out.println(isPalindrome("Муза! Ранясь шилом опыта, ты помолишься на разум."));
    }

    static boolean isPalindrome(String inputString) {
        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        String input = inputString.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 1072 || input.charAt(i) > 1103) {
                input = input.substring(0, i) + input.substring(i + 1);
                i--;
            }
        }

        String part1 = input.substring(0, input.length() / 2);
        String part2 = input.substring(input.length() - part1.length());

        for (int i = 0; i < part1.length() - 1; i++) {
            if (part1.charAt(i) != part2.charAt(part1.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
