package _5_search.binary_search;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
            return true;
        }
        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)) {
            return true;
        } else {
            if (searchItem < dataList.get(medium)) {
                return this.searchFunc(new ArrayList<>(dataList.subList(0, medium)), searchItem);
            } else {
                return this.searchFunc(new ArrayList<>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            testData.add((int) (Math.random() * 100));
        }

        Collections.sort(testData);

        boolean result = binarySearch.searchFunc(testData, 4);
        System.out.println("result = " + result);
    }
}
