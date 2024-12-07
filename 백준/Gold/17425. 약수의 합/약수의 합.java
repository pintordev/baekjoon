import java.io.IOException;

public class Main {
    public static int max = 1_000_000;
    public static long[] cSum = new long[max + 1];

    public static void main(String[] args) throws IOException {
        init();

        StringBuilder sb = new StringBuilder();
        int t = read();
        while (t-- > 0) {
            sb.append(cSum[read()]).append('\n');
        }
        System.out.print(sb);
    }

    public static void init() {
        long[] sum = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            for (int j = i; j <= max; j += i) {
                sum[j] += i;
            }
        }

        for (int i = 1; i <= max; i++) {
            cSum[i] = cSum[i - 1] + sum[i];
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}