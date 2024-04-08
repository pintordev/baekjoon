import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        int iter = read() + read();
        Map<Integer, Integer> snakeAndLadder = new HashMap<>();
        while (iter-- > 0) {
            snakeAndLadder.put(read(), read());
        }

        boolean[] visited = new boolean[101];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.x == 100) {
                System.out.println(now.cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nx = now.x + i;
                if (nx > 100 || visited[nx]) continue;
                visited[nx] = true;

                while (snakeAndLadder.containsKey(nx)) {
                    nx = snakeAndLadder.get(nx);
                }
                visited[nx] = true;

                queue.add(new Node(nx, now.cnt + 1));
            }
        }
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
    int cnt;

    public Node(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}