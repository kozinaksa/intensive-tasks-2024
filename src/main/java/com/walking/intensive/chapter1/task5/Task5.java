package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static boolean checkNoExistTriangle(double a, double b, double c) {
        return a + b < c || b + c < a || c + a < b;
    }

    public static double getSemiperimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public static double getCosine(double a, double b, double c) {
        return (Math.pow(a,2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
    }

    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        if (checkNoExistTriangle(a, b, c)) {
            return -1;
        }
        double p = getSemiperimeter(a, b, c);
        return Math.sqrt((p * (p - a) * (p - b) * (p - c)));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {
        double[] heightsTriangle;

        if (checkNoExistTriangle(a, b, c)) {
            heightsTriangle = new double[0];
            return heightsTriangle;
        }

        double areaTriangle = getAreaByHeron(a, b, c);

        heightsTriangle = new double[3];
        heightsTriangle[0] = 2 / a * areaTriangle;
        heightsTriangle[1] = 2 / b * areaTriangle;
        heightsTriangle[2] = 2 / c * areaTriangle;

        Arrays.sort(heightsTriangle);
        return heightsTriangle;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        double[] medians;

        if (checkNoExistTriangle(a, b, c)) {
            medians = new double[0];
            return medians;
        }

        medians = new double[3];
        medians[0] = 0.5 * Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2));
        medians[1] = 0.5 * Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2));
        medians[2] = 0.5 * Math.sqrt(2 * Math.pow(c, 2) + 2 * Math.pow(a, 2) - Math.pow(b, 2));

        Arrays.sort(medians);
        return medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        double[] bisectors;

        if (checkNoExistTriangle(a, b, c)) {
            bisectors = new double[0];
            return bisectors;
        }

        bisectors = new double[3];
        bisectors[0] = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        bisectors[1] = Math.sqrt(b * c * (a + b + c) * (b + c - a)) / (b + c);
        bisectors[2] = Math.sqrt(c * a * (a + b + c) * (c + a - b)) / (c + a);

        Arrays.sort(bisectors);
        return bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        double[] angles;

        if (checkNoExistTriangle(a, b, c)) {
            angles = new double[0];
            return angles;
        }

        angles = new double[3];
        angles[0] = Math.toDegrees(Math.acos(getCosine(a ,b, c)));
        angles[1] = Math.toDegrees(Math.acos(getCosine(b, c, a)));
        angles[2] = Math.toDegrees(Math.acos(getCosine(c, a ,b)));

        Arrays.sort(angles);
        return angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (checkNoExistTriangle(a, b, c)) {
            return -1;
        }

        double p = getSemiperimeter(a, b, c);
        return Math.sqrt((p - a) * (p - b) * (p - c) / p);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (checkNoExistTriangle(a, b, c)) {
            return -1;
        }

        return a * b * c / (4 * getAreaByHeron(a, b, c));
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if (checkNoExistTriangle(a, b, c)) {
            return -1;
        }

        double cosAB = getCosine(a, b, c);
        double sinAB = Math.sqrt(1 - Math.pow(cosAB, 2));
        return 0.5 * a * b * sinAB;
    }
}
