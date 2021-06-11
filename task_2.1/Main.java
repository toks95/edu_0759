/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.
Пример:
МылаРамуМама
РамуМамаМыла
...
Требования:
•	Программа должна выводить текст.
•	Выведенный текст должен содержать 6 строк.
•	Текст в каждой строке должен быть уникален.
•	Должны быть выведены все возможные комбинации. */

/* public class Main {
    public static void main(String[] args) {
        String a = "Мама";
        String b = "Мыла";
        String c = "Раму";
        System.out.println(a+b+c);
        System.out.println(a+c+b);
        System.out.println(b+a+c);
        System.out.println(b+c+a);
        System.out.println(c+a+b);
        System.out.println(c+b+a);

    }
}
*/



    public class Main {
        public static void main(String[] args) {
            String[] words = {"Мама", "Мыла", "Раму"};
            int word = 1;
            for (int i = 1; i <= words.length; i++) {
                word = word * i;
            }
            for (int i=0;i<3;i++)
                for (int j=0;j<3;j++)
                    if (i!=j)
                        System.out.println(words[i]+words[j]+words[3-i-j]);
        }
    }