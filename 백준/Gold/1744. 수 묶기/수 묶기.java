import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Integer> pos = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        int num;
        while (n-- > 0) {
            if ((num = read()) > 0) pos.add(num);
            else neg.add(num);
        }

        System.out.println(bind(pos) + bind(neg));
    }

    public static int bind(PriorityQueue<Integer> pq) {
        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a == 1 || b == 1) sum += a + b;
            else sum += a * b;
        }
        if (!pq.isEmpty()) sum += pq.poll();
        return sum;
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