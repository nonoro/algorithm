package _4_advanced_sort.quick;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int index = 1; index < dataList.size(); index++) {
            if (dataList.get(index) > pivot) {
                rightArr.add(dataList.get(index));
            } else {
                leftArr.add(dataList.get(index));
            }
        }

        System.out.println("leftArr = " + leftArr);
        System.out.println("pivot = " + pivot);
        System.out.println("rightArr = " + rightArr);

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(this.sort(leftArr));
        mergedArr.addAll(List.of(pivot));
        mergedArr.addAll(this.sort(rightArr));

        System.out.println("mergedArr = " + mergedArr);

        return mergedArr;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        quickSort.sort(new ArrayList<>(List.of(8, 21, 44, 4, 36, 1, 90)));
    }
}
