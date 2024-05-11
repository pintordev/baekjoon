import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        long[] sum = new long[n + 1];
        long[] count = new long[m];
        for (int i = 1; i <= n; i++) {
            sum[i] = (sum[i - 1] + read()) % m;
            count[(int) sum[i]]++;
        }

        long result = count[0];
        for (int i = 0; i < m; i++) {
            result += count[i] * (count[i] - 1) / 2;
        }
        System.out.println(result);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}