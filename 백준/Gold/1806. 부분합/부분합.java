import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int s = read();

        Queue<Integer> q = new ArrayDeque<>();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (n-- > 0) {
            int num = read();
            q.add(num);
            sum += num;
            while (sum >= s) {
                min = Math.min(min, q.size());
                sum -= q.poll();
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}