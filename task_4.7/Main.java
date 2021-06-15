/*
Реализуй в классе Fox интерфейс Animal.
Поменяй код так, чтобы в классе Fox был только один метод - getName.
Учти, что создавать дополнительные классы и удалять методы нельзя!

Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

import java.awt.*;

public class Main {
    public static void main(String[] args){
        Fox fox = new Fox();
        System.out.println(fox.getName());
        System.out.println(fox.getColor());
        fox.getColor();
    }
}

interface Animal {
    Color getColor();
}

class Fox implements Animal {
    public String getName() {
        return "Fox";
    }

    public Color getColor() { return null;
    }
}