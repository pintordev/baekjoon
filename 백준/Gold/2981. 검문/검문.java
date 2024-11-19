import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = read();
        }
        Arrays.sort(numbers);

        int gcd = numbers[1] - numbers[0];
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, numbers[i] - numbers[i - 1]);
        }

        Queue<Integer> f = new ArrayDeque<>();
        Stack<Integer> b = new Stack<>();
        b.add(gcd);
        for (int i = 2; i * i <= gcd; i++) {
            if (gcd % i != 0) continue;
            f.add(i);
            if (i * i == gcd) continue;
            b.add(gcd / i);
        }

        StringBuilder sb = new StringBuilder();
        while (!f.isEmpty()) {
            sb.append(f.poll()).append(' ');
        }
        while (!b.isEmpty()) {
            sb.append(b.pop()).append(' ');
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}