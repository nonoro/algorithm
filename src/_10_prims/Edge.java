package _10_prims;

public class Edge implements Comparable<Edge>{
    public int weight;
    public String node1;
    public String node2;

    public Edge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Edge{");
        sb.append("weight=").append(weight);
        sb.append(", node1='").append(node1).append('\'');
        sb.append(", node2='").append(node2).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}
