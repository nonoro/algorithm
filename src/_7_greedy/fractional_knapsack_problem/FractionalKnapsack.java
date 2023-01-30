package _7_greedy.fractional_knapsack_problem;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        System.out.println("objectList.length = " + objectList.length);

        Integer[] iArray = new Integer[]{1, 10, 4, 3, 2};
        Arrays.sort(iArray);
        System.out.println(Arrays.toString(iArray));

        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(10, "A");
        Edge edge3 = new Edge(13, "A");

        Edge[] edges = {edge1, edge2, edge3};
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.distance - o2.distance;
            }
        });
        for (Edge edge : edges) {
            System.out.println("edge = " + edge.distance);
        }
    }

    public static class Edge implements Comparable<Edge>{
        public Integer distance;
        public String vertex;

        public Edge (Integer distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

}
