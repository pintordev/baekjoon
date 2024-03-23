import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = read()) != -1) {
            Set<Integer> factors = new TreeSet<>();
            for (int i = 1; i * i <= n; i++) {
                if (n % i != 0) continue;
                factors.add(i);
                factors.add(n / i);
            }
            if (isPerfect(n, factors)) {
                factors.remove(n);
                sb.append(n).append(" = ");
                for (int factor : factors) sb.append(factor).append(" + ");
                sb.delete(sb.length() - 3, sb.length()).append('\n');
            } else {
                sb.append(n).append(" is NOT perfect.").append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean isPerfect(int n, Set<Integer> factors) {
        int sum = 0;
        for (int factor : factors) if (factor != n) sum += factor;
        return n == sum;
    }

    public static int read() throws IOException {
        boolean negative = false;
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            if (n == 13) {
                negative = true;
                n = c & 15;
            } else {
                n = (n << 3) + (n << 1) + (c & 15);
            }
        }
        return negative ? -1 * n : n;
    }
}