import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = read();
            y[i] = read();
        }
        x[n] = x[0];
        y[n] = y[0];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) x[i] * y[i + 1];
            sum -= (long) y[i] * x[i + 1];
        }
        System.out.println(String.format("%.1f", Math.abs(sum) / 2.0));
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