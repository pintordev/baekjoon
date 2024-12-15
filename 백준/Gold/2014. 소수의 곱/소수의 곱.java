import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int k = read();
        int n = read();

        long[] primes = new long[k];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            primes[i] = read();
            pq.add(primes[i]);
        }

        while (--n > 0) {
            long cur = pq.poll();
            for (long prime : primes) {
                pq.add(cur * prime);
                if (cur % prime == 0) break;
            }
        }
        System.out.println(pq.poll());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}