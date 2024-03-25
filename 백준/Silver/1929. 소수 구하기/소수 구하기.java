import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int m = read(), n = read();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) continue;
            if (i >= m) sb.append(i).append('\n');
            if (i * i > n) continue;
            for (int j = i + i; j <= n; j += i) isPrime[j] = false;
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