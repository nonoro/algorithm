package _1_basic.factorial;

public class Factorial1 {
    public int factorialFunc(int n) {
        int fac = 1;
        for (int index = 2; index < n + 1; index++) {
            fac = fac * index;
        }
        return fac;
    }

    public static void main(String[] args) {
        Factorial1 factorial1 = new Factorial1();
        int result = factorial1.factorialFunc(5);
        System.out.println("result = " + result);
    }
}
