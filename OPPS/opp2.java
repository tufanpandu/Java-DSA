import java.util.*;

public class opp2 {
    public static void main(String[] args) {
        Hourse h1 = new Hourse();

    }
}

class Animal {
    String color;

    Animal() {
        System.out.println("Animal Constructor is called");
    }

}

class Hourse extends Animal {
    Hourse() {
        super.color = "Brown";
        System.out.print("Hourse Constructor is called");
    }
}
