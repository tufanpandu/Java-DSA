
public class fibonacci {
    /**
     * -Fibonacci number serice looks like 0 ,1,1,2,3,5,8,13,21 .......like this
     * -Formula is - fib(n) = fib(n-1) + fib(n-2)
     */
    // nth fibonacci number
    public static int fib(int n) {
        // base Case
        if (n == 0 || n == 1) {
            return n;
        }
        // find fib(n-1) and fib(n-2)
        int fibOne = fib(n - 1);
        int fibTwo = fib(n - 2);
        // result
        int result = fibOne + fibTwo;
        return result;

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
    }
}
