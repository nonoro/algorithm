package _6_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Bfs {
        private HashMap<String, ArrayList<String>> graph = new HashMap<>();

    public ArrayList<String> bfsFunc1(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();
        int count = 0;
        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);
            count++;
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        System.out.println("count = " + count);
        return visited;
    }

    public static void main(String[] args) {
        Bfs bfs = new Bfs();
        bfs.graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        bfs.graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        bfs.graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        bfs.graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        bfs.graph.put("E", new ArrayList<>(Arrays.asList("D")));
        bfs.graph.put("F", new ArrayList<>(Arrays.asList("D")));
        bfs.graph.put("G", new ArrayList<>(Arrays.asList("C")));
        bfs.graph.put("H", new ArrayList<>(Arrays.asList("C")));
        bfs.graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        bfs.graph.put("J", new ArrayList<>(Arrays.asList("I")));
        ArrayList<String> result = bfs.bfsFunc1(bfs.graph, "A");
        System.out.println("result = " + result);
    }
}
