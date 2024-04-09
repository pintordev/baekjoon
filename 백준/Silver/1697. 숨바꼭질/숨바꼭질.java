import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

class Main {
    public static int[] visited = new int[100001];
    public static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        goIfCanMove(n, n);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == k) {
                System.out.println(visited[now] - 1);
                return;
            }

            goIfCanMove(now - 1, now);
            if (now >= k) continue;
            goIfCanMove(2 * now, now);
            goIfCanMove(now + 1, now);
        }
    }

    public static void goIfCanMove(int to, int from) {
        if (to < 0 || to > 100000) return;
        if (visited[to] > 0) return;
        queue.add(to);
        visited[to] = visited[from] + 1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}