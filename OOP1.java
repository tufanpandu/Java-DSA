public class OOP1 {
    public static void main(String[] args) {
        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(5, 9));
        // System.out.println(calc.sum((float) 1.5, (float) 8.5));
        // System.out.println(calc.sum(1, 8, 5));

        tufan name = new tufan();
        name.Hair();
        name.Reproduction();
        name.wallk();

    }
}

// Base Class / Parent Class
class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }

    void breat() {
        System.out.println("Breathes");
    }
}

//// Chile Class / Derived Class

class Fish extends Animal {
    void Swim() {
        System.out.println("Swimming");
    }

}

///// Method Overloading
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;

    }

    float sum(float a, float b) {
        return a + b;
    }
}

//// Interfaces

interface Man {
    void wallk();

    void Hair();

    void Reproduction();
}

class tufan implements Man {
    public void wallk() {
        System.out.println("Walk like Army");
    }

    public void Hair() {
        System.out.println("Short Hair");
    }

    public void Reproduction() {
        System.out.println("Male Reproductive system");
    }
}
