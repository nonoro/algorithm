package _5_search.sequential_search;

import java.util.ArrayList;

public class SequentialSearch {
    public int sequentialSearch(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SequentialSearch sequentialSearch = new SequentialSearch();
        ArrayList<Integer> testData = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            testData.add((int) (Math.random() * 100));
        }

        int result = sequentialSearch.sequentialSearch(testData, 4);
        System.out.println("result = " + result);
    }
}
