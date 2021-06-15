/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        while (true) {
            String family = scanner.nextLine();
            if (family.isEmpty()) {
                break;
            }

            list.add(family);
        }

        String city = scanner.nextLine();
        int i = list.indexOf(city);
        if (0 <= i && i < list.size()) {
            String Family = list.get(++i);
            System.out.println(Family);
        }
    }
}
