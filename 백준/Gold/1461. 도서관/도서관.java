import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = read();
            if (num < 0) {
                minQ.add(num);
            } else {
                maxQ.add(num);
            }
            max = Math.max(max, Math.abs(num));
        }

        int sum = 0;
        L: while (!minQ.isEmpty()) {
            sum += minQ.peek() * -2;
            for (int i = 0; i < m; i++) {
                if (minQ.isEmpty()) {
                    break L;
                }
                minQ.poll();
            }
        }
        R: while (!maxQ.isEmpty()) {
            sum += maxQ.peek() * 2;
            for (int i = 0; i < m; i++) {
                if (maxQ.isEmpty()) {
                    break R;
                }
                maxQ.poll();
            }
        }
        sum -= max;

        System.out.println(sum);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}