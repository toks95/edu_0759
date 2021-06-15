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
        Mouse jerryMouse = new Mouse ("Jerry", "male", "brown");
        Cat tomCat = new Cat ("Tom", "male", "silver");
        Dog spikeDog = new Dog ("Spike", "male", "lead-grey");
        Mouse nibblesMouse = new Mouse ("Nibbles", "male", "gray");
        System.out.println(jerryMouse.color);
    }
}
class Dog {
    String name;
    String gender;
    String color;

    public Dog (String name, String gender, String color) {
        this.name = name;
        this.gender = gender;
        this.color = color;
    }
}
class Cat {
    String name;
    String gender;
    String color;

    public Cat (String name, String gender, String color) {
        this.name = name;
        this.gender = gender;
        this.color = color;
    }
}
class Mouse {
    String name;
    String gender;
    String color;

    public Mouse (String name, String gender, String color) {
        this.name = name;
        this.gender = gender;
        this.color = color;
    }
}