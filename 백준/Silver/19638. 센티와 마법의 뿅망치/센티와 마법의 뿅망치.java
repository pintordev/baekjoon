import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int h = read();
        int t = read();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) {
            pq.add(read());
        }

        int cnt = 0;
        while (cnt < t && pq.peek() >= h) {
            int x = pq.poll();
            if (x > 1) {
                pq.add(x / 2);
            } else {
                pq.add(x);
            }
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        if (cnt == t && pq.peek() >= h) {
            sb.append("NO").append('\n').append(pq.peek());
        } else {
            sb.append("YES").append('\n').append(cnt);
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