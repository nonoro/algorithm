package _7_greedy.coin;

import java.util.ArrayList;
import java.util.Arrays;

public class GreedyAlgorithm {
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<>();

        for (int index = 0; index < coinList.size(); index++) {
            coinNum = price / coinList.get(index);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index) + "원 " + coinNum + "개");
        }
        System.out.println("총 동전 갯수: " + totalCoinCount);
    }

    public static void main(String[] args) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm();
        greedyAlgorithm.coinFunc(4720, new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1)));

    }
}
