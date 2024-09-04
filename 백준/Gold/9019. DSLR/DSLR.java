import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(simulate(read(), read())).append('\n');
        }
        System.out.println(sb);
    }

    public static String simulate(int a, int b) {
        boolean[] visited = new boolean[10000];

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(a, ' ', null));
        visited[a] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.num == b) {
                StringBuilder sb = new StringBuilder();
                while (cur.prev != null) {
                    sb.append(cur.command);
                    cur = cur.prev;
                }
                return sb.reverse().toString();
            }

            int d = (cur.num << 1) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                q.offer(new Node(d, 'D', cur));
            }

            int s = cur.num == 0 ? 9999 : cur.num - 1;
            if (!visited[s]) {
                visited[s] = true;
                q.offer(new Node(s, 'S', cur));
            }

            int l = (cur.num % 1000) * 10 + cur.num / 1000;
            if (!visited[l]) {
                visited[l] = true;
                q.offer(new Node(l, 'L', cur));
            }

            int r = (cur.num % 10) * 1000 + cur.num / 10;
            if (!visited[r]) {
                visited[r] = true;
                q.offer(new Node(r, 'R', cur));
            }
        }

        return null;
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
    int num;
    char command;
    Node prev;

    public Node(int num, char command, Node prev) {
        this.num = num;
        this.command = command;
        this.prev = prev;
    }
}