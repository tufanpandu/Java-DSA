package OPPS;

public class OOP {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Tufan Chandra Pandu";
        s1.roll = 542;
        s1.password = "abcd";

        Student s2 = new Student(s1);
        s2.password = "xyz";

    }
}

//// Non - Parameterized
class Student {
    String name;
    int roll;
    String password;

    //// Copy Constructor
    Student(Student s1) {
        this.name = s1.name;
        this.roll = s1.roll;

    }

    Student() {
        System.out.println("Constructor is called");
    }

    Student(String name) {
        this.name = name;

    }

    Student(int roll) {
        this.roll = roll;
    }

}

////// Parameterized
class Tree {
    String name;
    int noOf;

    public Tree(String name, int noTree) {
        this.name = name;
        this.noOf = noTree;
    }
}
