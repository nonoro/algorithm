package _8_shortest_route;

import java.util.PriorityQueue;

public class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Edge{");
        sb.append("distance=").append(distance);
        sb.append(", vertex='").append(vertex).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }

    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.add(new Edge(1, "C"));
        priorityQueue.add(new Edge(7, "D"));

        System.out.println(priorityQueue);

        Edge peek = priorityQueue.peek();

        System.out.println("peek = " + peek);

        priorityQueue.poll();

        System.out.println("priorityQueue = " + priorityQueue);

    }
}
