package _4_advanced_sort.merge;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public ArrayList<Integer> splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr;
        ArrayList<Integer> rightArr;

        leftArr = this.splitFunc(new ArrayList<>(dataList.subList(0, medium)));
        System.out.println("leftArr = " + leftArr);
        rightArr = this.splitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));
        System.out.println("rightArr = " + rightArr);
        System.out.println("=================================");

//        System.out.println("leftArr = " + leftArr);
//        System.out.println("rightArr = " + rightArr);
//        System.out.println("=================================");

        return this.mergeFunc(leftArr, rightArr);
    }

    public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1: left/right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint += 1;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint += 1;
            }
        }

        // CASE2: right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint += 1;
        }
        // CASE3: left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint += 1;
        }
        System.out.println("mergedList = " + mergedList);
        return mergedList;
    }

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

//        ArrayList<Integer> testData = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            testData.add((int)(Math.random() * 100));
//        }
        ArrayList<Integer> testData = new ArrayList<>(List.of(2, 16, 46, 235, 34, 22, 14, 69));

        ArrayList<Integer> result = mergeSort.splitFunc(testData);

        System.out.println("result = " + result);
    }
}
