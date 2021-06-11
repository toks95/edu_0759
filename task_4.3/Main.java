/*
Реализовать метод boolean fight(Cat anotherCat):
реализовать механизм драки котов в зависимости от их веса, возраста и силы.
Нужно сравнить каждый критерий по отдельности, и победителем будет тот, у которого больше "победивших" критериев.
Метод должен определять, выиграли ли мы (this) бой или нет, т.е. возвращать true, если выиграли и false - если нет.
Если ничья и никто не выиграл, возвращаем либо true либо false, по вашему усмотрению
Требования:
•	Класс Cat должен содержать конструктор без параметров.
•	Класс Cat должен содержать всего три поля: age, weight и strength. Поля должны быть публичные.
•	В классе Cat должен быть метод fight.
•	В методе fight реализовать механизм драки котов в зависимости от их веса, возраста и силы согласно условию.
•	Метод должен возвращать одно и тоже значение, если мы деремся с одним и тем же котом.
•	Если некий кот1 выигрывает у кота кот2, то кот2 должен проигрывать коту кот1.
*/

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat(2, 4, 6);
        Cat cat2 = new Cat(3, 6, 5);
        System.out.println("Этот кот всего лишь думает, что выиграл. " + cat1.fight(cat2));
    }
}

class Cat {

    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public Cat(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(Cat anotherCat) {
        int ourCount = 0;
        int enemyCount = 0;
        if (this.age > anotherCat.age) ourCount++;
        else if (this.age < anotherCat.age) enemyCount++;
        else {
            ourCount++;
            enemyCount++;
        }
        if (this.weight > anotherCat.weight) ourCount++;
        else if (this.weight < anotherCat.weight) enemyCount++;
        else {
            ourCount++;
            enemyCount++;
        }
        if (this.strength > anotherCat.strength) ourCount++;
        else if (this.strength < anotherCat.strength) enemyCount++;
        else {
            ourCount++;
            enemyCount++;
        }
        return ourCount > enemyCount;
    }

}
