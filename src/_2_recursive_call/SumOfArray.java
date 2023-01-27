package _2_recursive_call;

import java.util.ArrayList;

public class SumOfArray {

    public int sumOfArrayFunc(ArrayList<Integer> dataList) {
        if (dataList.size() == 0) {
            return 0;
        }
        return dataList.get(0) + this.sumOfArrayFunc(new ArrayList<>(dataList.subList(1, dataList.size())));
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int data = 0; data < 10; data++) {
            testData.add(data);
        }
        System.out.println("testData = " + testData);
        System.out.println("testData.subList(1, testData.size()) = " + testData.subList(1, testData.size()));

        SumOfArray sumOfArray = new SumOfArray();
        int result = sumOfArray.sumOfArrayFunc(testData);

        System.out.println("result = " + result);
    }
}

