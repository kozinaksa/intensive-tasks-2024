package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (isNegativeNumber(m, n)) {
            return -1;
        }

        int gcd = getGcdByEuclideanAlgorithm(m, n);

        return m * n / gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (isNegativeNumber(m, n)) {
            return -1;
        }

        if (isGcdParameterExist(m, n)) {
            return Math.min(n, m);
        }

        int gcd = 1;
        int divisor = 2;

        while (divisor < m && divisor < n) {
            if (m % divisor == 0 && n % divisor == 0) {
                m /= divisor;
                n /= divisor;
                gcd *= divisor;
            }
            divisor++;
        }

        return gcd;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью алгоритма Евклида
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (isNegativeNumber(m, n)) {
            return -1;
        }

        if (isGcdParameterExist(m, n)) {
            return Math.min(n, m);
        }

        int gcd = 1;
        int maxNum = Math.max(m, n);
        int minNum = Math.min(m, n);

        while (maxNum % minNum != 0) {
            gcd = maxNum % minNum;
            maxNum = minNum;
            minNum = gcd;
        }

        return gcd;
    }

    static boolean isNegativeNumber(int m, int n) {
        return m <= 0 || n <= 0;
    }

    static boolean isGcdParameterExist(int m, int n) {
        return Math.max(m, n) % Math.min(m, n) == 0;
    }
}
