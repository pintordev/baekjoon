import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(read());
        }

        int cnt = 0;
        while (k > 0) {
            if (k >= pq.peek()) {
                cnt += k / pq.peek();
                k %= pq.poll();
            } else {
                pq.poll();
            }
        }
        System.out.println(cnt);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}