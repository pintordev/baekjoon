import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] num = new int[n], freq = new int[8001];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            num[i] = read();
            sum += num[i];
            freq[num[i] + 4000]++;
        }
        Arrays.sort(num);

        int maxf = 0, maxv = -4001;
        boolean isSecond = false;
        for (int i = 0; i < 8001; i++) {
            if (maxf < freq[i]) {
                maxf = freq[i];
                maxv = i;
                isSecond = false;
            } else if (maxf == freq[i] && !isSecond) {
                maxv = i;
                isSecond = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / n)).append('\n');
        sb.append(num[n / 2]).append('\n');
        sb.append(maxv - 4000).append('\n');
        sb.append(num[n - 1] - num[0]).append('\n');
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