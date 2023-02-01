package _8_shortest_route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {

    HashMap<String, ArrayList<Edge>> graph = new HashMap<>();

    public static void main(String[] args) {
        DijkstraPath dObject = new DijkstraPath();
        HashMap<String, ArrayList<Edge>> shortGraph = dObject.graph;
        shortGraph.put("A", new ArrayList<>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        shortGraph.put("B", new ArrayList<>());
        shortGraph.put("C", new ArrayList<>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        shortGraph.put("D", new ArrayList<>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        shortGraph.put("E", new ArrayList<>(Arrays.asList(new Edge(1, "F"))));
        shortGraph.put("F", new ArrayList<>(Arrays.asList(new Edge(5, "A"))));

        for (String key : shortGraph.keySet()) {
            System.out.println("key = " + key);
        }

        HashMap<String, Integer> result = dObject.dijkstraPathFunc(shortGraph, "A");
        System.out.println("result = " + result);

    }

    public HashMap<String, Integer> dijkstraPathFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        ArrayList<Edge> nodeList;
        // 거리배열
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // 우선순위 큐
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }
}
