package _2_recursive_call;

public class Factorial {
    public int factorialFunc1(int n) {
        if (n > 1) {
            return n * this.factorialFunc1(n - 1);
        } else {
            return 1;
        }
    }

    public int factorialFunc2(int n) {
        if (n <= 1) {
            return 1;
        }
            return n * this.factorialFunc2(n - 1);
    }


    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println("factorial.factorialFunc1(3) = " + factorial.factorialFunc1(5));
        System.out.println("factorial.factorialFunc2(3) = " + factorial.factorialFunc2(5));
    }
}
