import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(read());
        }

        int sum = 0;
        while (n-- > 0) {
            if (sum + 1 < pq.peek()) break;
            sum += pq.poll();
        }
        System.out.println(sum + 1);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}