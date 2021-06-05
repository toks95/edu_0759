/*
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
Требования:
•	Программа не должна считывать данные с клавиатуры.
•	У класса Dog должна быть переменная name с типом String.
•	У класса Dog должна быть переменная age с типом int.
•	У класса должен быть сеттер для переменной name.
•	У класса должен быть геттер для переменной name.
•	У класса должен быть сеттер для переменной age.
•	У класса должен быть геттер для переменной age.
*/


public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println("Our dog name's " + dog.getName() + "\n His age's " + dog.getAge());
    }
}

class Dog {
    private String name = "Яша";
    private int age = 3;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}

