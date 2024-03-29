import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int n = read();
        while (n-- > 0) {
            int m = read();
            int pdx = read();
            int order = 1;

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < m; i++) {
                int priority = read();
                queue.add(new int[]{i, priority});
                pq.add(priority);
            }

            while (!queue.isEmpty()) {
                while (queue.peek()[1] < pq.peek()) queue.add(queue.poll());
                if (queue.peek()[0] == pdx) {
                    sb.append(order).append('\n');
                    break;
                }
                queue.poll();
                pq.poll();
                order++;
            }
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}