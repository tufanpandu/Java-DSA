import java.util.*;

public class SimpleIntrest {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your principal amount.");
        float principal = sc.nextFloat();
        System.out.println("Enter what rate of intrest you get.");
        float intrestRate = sc.nextFloat();
        System.out.println("Enter year of investment ");
        float forYears = sc.nextFloat();
        float si = (principal * intrestRate * forYears) / 100;
        System.out.println(" Your total simple intrest amount is :" + si);
    }
}
