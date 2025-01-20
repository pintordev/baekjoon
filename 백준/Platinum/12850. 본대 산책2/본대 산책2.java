import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;
    public static long[][] adj = {
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 0},
            {1, 1, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 1, 0},
            {0, 0, 1, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        System.out.println(pow(read())[0][0]);
    }

    public static long[][] pow(int d) {
        if (d == 1) return adj;

        long[][] half = pow(d / 2);
        return d % 2 == 0 ? mul(half, half) : mul(mul(half, half), adj);
    }

    public static long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= mod;
                }
            }
        }
        return c;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}