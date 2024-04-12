import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static int x;
    public static List<Node>[] fGraph;
    public static List<Node>[] rGraph;
    public static int[] fDist;
    public static int[] rDist;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra(fGraph, fDist);
        dijkstra(rGraph, rDist);
        findMax();
    }

    public static void dijkstra(List<Node>[] graph, int[] dist) {
        visited = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));
        dist[x] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Node next : graph[now.end]) {
                if (visited[next.end] || dist[next.end] <= dist[now.end] + next.time) {
                    continue;
                }
                dist[next.end] = dist[now.end] + next.time;
                pq.add(new Node(next.end, dist[next.end]));
            }
        }
    }

    public static void findMax() {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, fDist[i] + rDist[i]);
        }
        System.out.println(max);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);

        fGraph = new List[n + 1];
        rGraph = new List[n + 1];
        fDist = new int[n + 1];
        rDist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            fGraph[i] = new ArrayList<>();
            rGraph[i] = new ArrayList<>();
            fDist[i] = Integer.MAX_VALUE;
            rDist[i] = Integer.MAX_VALUE;
        }

        while (m-- > 0) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);
            fGraph[start].add(new Node(end, time));
            rGraph[end].add(new Node(start, time));
        }
    }
}

class Node implements Comparable<Node> {
    int end;
    int time;

    public Node(int end, int time) {
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}