package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
/*
        int floorAmount = 10;
        int entranceAmount = 3;
        int flatNumber = 40;
        System.out.println(getFlatLocation(floorAmount, entranceAmount, flatNumber));
*/
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        if (floorAmount <= 0 | entranceAmount <= 0 | flatNumber <= 0) {
            return "Некорректные входные данные";
        }

        if (floorAmount * entranceAmount * 4 < flatNumber) {
            return "Такой квартиры не существует";
        }

        int flat = flatNumber;
        int flatPerFloor = 4;
        int flatPerEntrance = flatPerFloor * floorAmount;
        int entranceNumber = (flatNumber + flatPerEntrance - 1) / flatPerEntrance;
        int floorNumber;

        if (flatNumber > flatPerEntrance) {
            flat = flatNumber - flatPerEntrance * (entranceNumber - 1); //pretend flat in the first entrance
        }

        floorNumber = (flat + flatPerFloor - 1) / flatPerFloor;

        if (flat > 4) {
            flat -= (floorNumber - 1) * flatPerFloor; //pretend flat on the first floor
        }

        String spatial = switch (flat) {
            case 1 -> "слева от лифта, влево";
            case 2 -> "слева от лифта, вправо";
            case 3 -> "справа от лифта, влево";
            case 4 -> "справа от лифта, вправо";
            default -> "прямо-прямо";
        };

        return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + spatial;
    }
}
