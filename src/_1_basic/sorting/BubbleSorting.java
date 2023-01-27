package _1_basic.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSorting {
    public void bubbleSorting1() {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(4);
        dataList.add(2);
        System.out.println(dataList);

        if (dataList.get(0) > dataList.get(1)) {
            Collections.swap(dataList, 0, 1);
        }
        System.out.println(dataList);
    }

    public void bubbleSorting2() {
        ArrayList<Integer> dataList = new ArrayList<>();
        dataList.add(9);
        dataList.add(2);
        dataList.add(4);

        for (int i = 0; i < dataList.size() - 1; i++) {
            if (dataList.get(i) > dataList.get(i + 1)) {
                Collections.swap(dataList, i, i + 1);
            }
        }
    }

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            boolean swap = false;

            for (int index2 = 0; index2 < dataList.size() - 1 - index; index2++) {
                if (dataList.get(index2) > dataList.get(index2 + 1)) {
                    System.out.println(index2 + 1);
                    Collections.swap(dataList, index2, index2 + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dataList.add((int)(Math.random() * 100));
        }

        BubbleSorting bubbleSorting = new BubbleSorting();
        ArrayList<Integer> integers = bubbleSorting.sort(dataList);
        System.out.println("integers = " + integers);
    }

}
