import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static int n;
    public static int k;
    public static int[] prev;

    public static void main(String[] args) throws IOException {
        n = read();
        k = read();

        StringBuilder sb = new StringBuilder();
        prev = new int[100_001];
        sb.append(bfs()).append('\n');

        Stack<Integer> stack = new Stack<>();
        while (k != n) {
            stack.push(k);
            k = prev[k];
        }
        stack.push(n);
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }

    public static int bfs() {
        boolean[] v = new boolean[100_001];

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(n, 0));
        v[n] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x == k) return cur.t;

            int x = cur.x;
            int t = cur.t;

            if (x - 1 >= 0 && !v[x - 1]) {
                q.add(new Node(x - 1, t + 1));
                v[x - 1] = true;
                prev[x - 1] = x;
            }

            if (x + 1 <= 100_000 && !v[x + 1]) {
                q.add(new Node(x + 1, t + 1));
                v[x + 1] = true;
                prev[x + 1] = x;
            }

            if (x * 2 <= 100_000 && !v[x * 2]) {
                q.add(new Node(x * 2, t + 1));
                v[x * 2] = true;
                prev[x * 2] = x;
            }
        }

        return -1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node {
    int x;
    int t;

    public Node(int x, int t) {
        this.x = x;
        this.t = t;
    }
}