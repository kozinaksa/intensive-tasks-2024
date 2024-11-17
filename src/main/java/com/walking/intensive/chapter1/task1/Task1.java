package com.walking.intensive.chapter1.task1;

/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int age = -10;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        int lastDigit = age % 10;
        int penultDigit = age / 10 % 10;

        if (age < 0) {
            return "Некорректный ввод";
        }

        switch (lastDigit) {
            case 1:
                if (penultDigit == 1) {
                    return "Вам " + age + " лет";
                }
                else {
                    return "Вам " + age + " год";
                }
            case 2:
            case 3:
            case 4:
                if (penultDigit == 1) {
                    return "Вам " + age + " лет";
                }
                else {
                    return "Вам " + age + " года";
                }
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return "Вам " + age + " лет";
            default:
                return "Некорректный ввод";
        }
    }
}
