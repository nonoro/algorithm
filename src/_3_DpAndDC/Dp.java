package _3_DpAndDC;

public class Dp {

    // recursive call
    public int fibonacciFunc(int data) {
        if (data <= 1) {
            return data;
        }
        return this.fibonacciFunc(data - 1) + this.fibonacciFunc(data - 2);
    }

    public int dynamicFunc(int data) {
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int index = 2; index < cache.length; index++) {
            cache[index] = cache[index - 1] + cache[index - 2];
        }
        return cache[data];
    }

    public static void main(String[] args) {
        Dp dp = new Dp();
        int result = dp.fibonacciFunc(10);
        System.out.println("result = " + result);

        int result2 = dp.dynamicFunc(10);
        System.out.println("result2 = " + result2);
    }
}


