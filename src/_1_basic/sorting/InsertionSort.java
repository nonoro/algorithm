package _1_basic.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add((int) (Math.random() * 100));
        }

        SelectionSort selectionSort = new SelectionSort();
        ArrayList<Integer> sort = selectionSort.sort(integers);
        System.out.println("sort = " + sort);
    }
}
