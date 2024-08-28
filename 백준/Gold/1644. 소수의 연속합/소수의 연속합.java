import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static int n;
    public static boolean[] np;

    public static void main(String[] args) throws IOException {
        n = read();

        eratosthenes();
        System.out.println(count());
    }

    public static void eratosthenes() {
        np = new boolean[n + 1];
        np[0] = np[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (np[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                np[j] = true;
            }
        }
    }

    public static int count() {
        int cnt = 0;
        int sum = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 2; i <= n; i++) {
            if (np[i]) continue;
            q.add(i);
            sum += i;
            while (sum > n) {
                sum -= q.poll();
            }
            if (sum == n) cnt++;
        }
        return cnt;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}