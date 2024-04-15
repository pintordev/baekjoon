import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static List<Node>[] graph;
    public static int[] feed;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        feed[1] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.end == n) {
                System.out.println(feed[n]);
                return;
            }
            if (now.feed > feed[now.end]) {
                continue;
            }

            for (Node next : graph[now.end]) {
                if (feed[next.end] <= feed[now.end] + next.feed) {
                    continue;
                }
                feed[next.end] = feed[now.end] + next.feed;
                pq.add(new Node(next.end, feed[next.end]));
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        graph = new List[n + 1];
        feed = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            feed[i] = Integer.MAX_VALUE;
        }

        while (m-- > 0) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int feed = Integer.parseInt(input[2]);
            graph[start].add(new Node(end, feed));
            graph[end].add(new Node(start, feed));
        }
    }
}

class Node implements Comparable<Node> {
    int end;
    int feed;

    public Node(int end, int feed) {
        this.end = end;
        this.feed = feed;
    }

    @Override
    public int compareTo(Node o) {
        return this.feed - o.feed;
    }
}