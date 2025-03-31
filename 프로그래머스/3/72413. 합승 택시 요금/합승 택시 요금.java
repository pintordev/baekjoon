import java.util.*;

class Solution {
    public static List<Node>[] graph;
    public static int[] sCost;
    public static int[] aCost;
    public static int[] bCost;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] fare : fares) {
            graph[fare[0]].add(new Node(fare[1], fare[2]));
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        sCost = new int[n + 1];
        aCost = new int[n + 1];
        bCost = new int[n + 1];

        dijkstra(n, s, sCost);
        dijkstra(n, a, aCost);
        dijkstra(n, b, bCost);

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minCost = Math.min(minCost, sCost[i] + aCost[i] + bCost[i]);
        }
        return minCost;
    }

    public void dijkstra(int n, int p, int[] pCost) {
        for (int i = 1; i <= n; i++) pCost[i] = Integer.MAX_VALUE;
        pCost[p] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(p, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (pCost[cur.idx] < cur.cost) continue;
            for (Node next : graph[cur.idx]) {
                int cost = cur.cost + next.cost;
                if (cost < pCost[next.idx]) {
                    pCost[next.idx] = cost;
                    pq.add(new Node(next.idx, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}