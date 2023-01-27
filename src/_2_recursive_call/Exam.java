package _2_recursive_call;

public class Exam {
    public int factorialFunc(int data) {
        if (data == 1) {
            return 1;
        } else if (data == 2) {
            return 2;
        } else if (data == 3) {
            return 4;
        }
        return this.factorialFunc(data - 1) + this.factorialFunc(data - 2) + this.factorialFunc(data - 3);
    }

    public static void main(String[] args) {
        Exam exam = new Exam();
        int result = exam.factorialFunc(5);
        System.out.println("result = " + result);
    }
}
