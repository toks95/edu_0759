  
/* 
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите путь: ");
        try {
            FileInputStream fis = new FileInputStream(scan.nextLine());
            scan = new Scanner(fis);
            TreeSet<Integer> numbers = new TreeSet<>();
            while (scan.hasNext()){
                int data = scan.nextInt();
                if (data %2==0) numbers.add(data);
            }
            for (int i : numbers) System.out.println(i);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
