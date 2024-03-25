import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();
        int max = 0, n;
        while ((n = read()) != 0) {
            list.add(n);
            max = Math.max(max, n);
        }

        boolean[] isPrime = new boolean[2 * max + 1];
        int[] count = new int[2 * max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        int c = 0;
        for (int i = 2; i <= 2 * max; i++) {
            if (!isPrime[i]) {
                count[i] = c;
                continue;
            }
            count[i] = ++c;
            if (i * i > 2 * max) continue;
            for (int j = i + i; j <= 2 * max; j += i) isPrime[j] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) sb.append(count[2 * i] - count[i]).append('\n');
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