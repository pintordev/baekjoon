import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] freq = new int[8001];
        int sum = 0, max = 0, min = 8000;
        for (int i = 0; i < n; i++) {
            int num = read();
            sum += num;
            freq[num + 4000]++;
            max = Math.max(max, num + 4000);
            min = Math.min(min, num + 4000);
        }

        int maxf = 0, maxv = -4001, mid = 0, midf = 0;
        boolean isSecond = false, findMid = false;
        for (int i = min; i <= max; i++) {
            if (maxf < freq[i]) {
                maxf = freq[i];
                maxv = i;
                isSecond = false;
            } else if (maxf == freq[i] && !isSecond) {
                maxv = i;
                isSecond = true;
            }

            midf += freq[i];
            if (!findMid && midf >= n / 2 + 1) {
                mid = i - 4000;
                findMid = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / n)).append('\n');
        sb.append(mid).append('\n');
        sb.append(maxv - 4000).append('\n');
        sb.append(max - min).append('\n');
        System.out.println(sb);
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