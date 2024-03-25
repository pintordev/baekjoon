import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), max = 0;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = read();
            max = Math.max(max, num[i]);
        }

        boolean[] isPrime = new boolean[2 * max + 1];
        isPrime[0] = true;
        isPrime[1] = true;
        for (int i = 2; i * i <= 2 * max; i++) {
            if (isPrime[i]) continue;
            for (int j = i + i; j <= 2 * max; j += i) isPrime[j] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 2; j <= num[i] / 2; j++) {
                if (!isPrime[j] && !isPrime[num[i] - j]) count++;
            }
            sb.append(count).append('\n');
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