import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 3;

        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (int i = 0; i < n; i++) {
            x[i] = read();
            y[i] = read();
        }
        x[n] = x[0];
        y[n] = y[0];

        int factor = 0;
        for (int i = 0; i < n; i++) {
            factor += x[i] * y[i + 1] - x[i + 1] * y[i];
        }
        
        if (factor < 0) System.out.println(-1);
        else if (factor > 0) System.out.println(1);
        else System.out.println(0);
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