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
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        int[] count = new int[list.size()];
        for (int i = 2; i <= 2 * max; i++) {
            if (!isPrime[i]) continue;
            for (int j = 0; j < count.length; j++) {
                int m = list.get(j);
                if (i > m && i <= 2 * m) count[j]++;
            }
            if ((long) i * i > 2 * max) continue;
            for (int j = i + i; j <= 2 * max; j += i) isPrime[j] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int c : count) sb.append(c).append('\n');
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