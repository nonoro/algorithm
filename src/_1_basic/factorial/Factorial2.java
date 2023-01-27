package _1_basic.factorial;

public class Factorial2 {
    public int factorialFunc(int n) {
        if (n > 1) {
            return n * factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Factorial2 factorial1 = new Factorial2();
        int result = factorial1.factorialFunc(5);
        System.out.println("result = " + result);
    }
}
