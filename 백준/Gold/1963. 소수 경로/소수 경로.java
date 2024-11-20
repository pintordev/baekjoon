import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static boolean[] complex = new boolean[10000];
    public static int[] f = {1000, 100, 10, 1};

    public static void main(String[] args) throws IOException {
        findComplex();

        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int res = bfs(read(), read());
            if (res == -1) sb.append("Impossible").append('\n');
            else sb.append(res).append('\n');
        }
        System.out.print(sb);
    }

    public static void findComplex() {
        for (int i = 2; i < 10000; i++) {
            if (complex[i]) continue;
            for (int j = i * i; j < 10000; j += i) {
                complex[j] = true;
            }
        }
    }

    public static int bfs(int s, int e) {
        boolean[] visited = new boolean[10000];

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int num = cur.num;
            int cnt = cur.cnt;

            if (num == e) return cnt;

            int[] digits = new int[]{num / 1000, num / 100 % 10, num / 10 % 10, num % 10};
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) continue;

                    int next = num - digits[i] * f[i] + j * f[i];

                    if (visited[next] || complex[next]) continue;
                    q.add(new Node(next, cnt + 1));
                    visited[next] = true;
                }
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
    int num;
    int cnt;

    public Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}