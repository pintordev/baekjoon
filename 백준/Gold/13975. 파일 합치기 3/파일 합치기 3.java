import java.io.IOException;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int k;
        while (t-- > 0) {
            k = read();
            while (k-- > 0) {
                pq.add((long) read());
            }

            long sum = 0;
            while (pq.size() > 1) {
                long localSum = pq.poll() + pq.poll();
                sum += localSum;
                pq.add(localSum);
            }
            sb.append(sum).append('\n');
            pq.clear();
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