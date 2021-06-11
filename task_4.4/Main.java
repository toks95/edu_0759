/*
Создай классы Dog, Cat, Mouse.
Добавь по три поля в каждый класс, на твой выбор.
Создай объекты для героев мультика Том и Джерри.
Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse("Jerry", 12 , 5),
где 12 - высота в см,
5 - длина хвоста в см.
Требования:
•	Создай класс Dog.
•	Создай класс Cat.
•	В классе Dog должно быть три переменные.
•	В классе Cat должно быть три переменные.
•	Должен быть создан хотя бы один объект типа Mouse.
•	Должен быть создан хотя бы один объект типа Dog.
•	Должен быть создан хотя бы один объект типа Cat.
*/

public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 10, 5);
        Cat tomCat = new Cat("Tom", 40, 5);
        Dog spikeDog = new Dog("Spike", 50, 10);
        Homeowner mammyHomeowner = new Homeowner ("Mammy Two Shoes", 60, 15);
        System.out.println(jerryMouse.toString() + "\n" + tomCat + "\n" + spikeDog + "\n" + mammyHomeowner);
    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse (String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Cat {
    String name;
    String ownerName;
    double height;

    public Cat (String name, String ownerName, double height) {
        this.name = name;
        this.ownerName = ownerName;
        this.height = height;
    }
}
class Dog {
    String name;
    String fatherName;
    boolean isEnemyOfJerry;

    public Dog (String name, String fatherName, boolean isEnemyOfJerry) {
        this.name = name;
        this.fatherName = fatherName;
        this.isEnemyOfJerry = isEnemyOfJerry;
    }
}
class Homeowner {
    String name;
    String fatherName;
    boolean isEnemyOfJerry;

    public Homeowner (String name, String fatherName, boolean isEnemyOfJerry) {
        this.name = name;
        this.fatherName = fatherName;
        this.isEnemyOfJerry = isEnemyOfJerry;
    }
}
