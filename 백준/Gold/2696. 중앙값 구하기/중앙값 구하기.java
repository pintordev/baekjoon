import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {

            int n = read();
            sb.append((n + 1) >> 1).append('\n');

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int x = read();
                if (max.size() == min.size()) max.add(x);
                else min.add(x);

                if (!min.isEmpty() && min.peek() < max.peek()) {
                    int a = max.poll();
                    int b = min.poll();
                    max.add(b);
                    min.add(a);
                }

                if (i % 2 == 1) continue;

                if (cnt == 9 || i == n - 1) {
                    sb.append(max.peek()).append('\n');
                    cnt = 0;
                } else {
                    sb.append(max.peek()).append(' ');
                }
                cnt++;
            }
        }
        System.out.print(sb);
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