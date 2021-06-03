/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада:");
        float a = scanner.nextInt();

        System.out.println("Введите процент:");

        float b = scanner.nextInt();
        float result = a;
        for (int i = 1; i <=5;i++ ) {

            result= (float)(result* (b+100.)/ 100.);
            System.out.println(i+" год: "+result);
        }

    }
}