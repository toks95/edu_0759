/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {

        int[] array = {10, 1, 2, 3, 4, 5, 6};
        int j=0;
        for (int i = 0; i < array.length; i++) {
            j=j+array[i];
            if (j>10) System.out.print(i+1);
            if (j>10) break;
        }
    }
}