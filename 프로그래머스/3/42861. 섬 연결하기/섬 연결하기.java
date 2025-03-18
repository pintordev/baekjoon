import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<Edge>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] cost : costs) {
            graph[cost[0]].add(new Edge(cost[1], cost[2]));
            graph[cost[1]].add(new Edge(cost[0], cost[2]));
        }
        
        boolean[] visited = new boolean[n];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        int minCost = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.node]) continue;
            visited[cur.node] = true;
            minCost += cur.cost;
            for (Edge next : graph[cur.node]) {
                if (!visited[next.node]) pq.add(next);
            }
        }
        return minCost;
    }
}

class Edge implements Comparable<Edge> {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}