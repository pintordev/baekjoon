import java.util.*;

class Solution {
    public static int n;
    public static Set<Integer> gates;
    public static Set<Integer> summits;
    public static List<Node>[] graph;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.n = n;
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(new Node(path[1], path[2]));
            graph[path[1]].add(new Node(path[0], path[2]));
        }
        this.gates = new HashSet<>();
        for (int gate : gates) {
            this.gates.add(gate);
        }
        this.summits = new HashSet<>();
        for (int summit : summits) {
            this.summits.add(summit);
        }

        return dijkstra();
    }

    public int[] dijkstra() {
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int gate : gates) {
            pq.add(new Node(gate, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (intensity[cur.to] < cur.time) continue;
            for (Node next : graph[cur.to]) {
                if (gates.contains(next.to)) continue;
                int nextTime = Math.max(cur.time, next.time);
                if (intensity[next.to] <= nextTime) continue;
                intensity[next.to] = nextTime;
                if (summits.contains(next.to)) continue;
                pq.add(new Node(next.to, nextTime));
            }
        }

        int minSdx = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        for (int summit : summits) {
            if (minIntensity < intensity[summit]) continue;
            if (minIntensity == intensity[summit]) {
                minSdx = Math.min(minSdx, summit);
            } else {
                minSdx = summit;
            }
            minIntensity = intensity[summit];
        }
        return new int[]{minSdx, minIntensity};
    }
}

class Node implements Comparable<Node> {
    int to;
    int time;

    public Node(int to, int time) {
        this.to = to;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}