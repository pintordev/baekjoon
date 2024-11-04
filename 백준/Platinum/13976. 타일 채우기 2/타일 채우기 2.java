import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        System.out.println(simulate(read()));
    }

    public static int simulate(long n) {
        if ((n & 1) == 1) return 0;

        long[][] a = {{1, 0}, {0, 1}};
        long[][] r = {{4, -1}, {1, 0}};
        long[][] b = {{1, 0}, {1, 0}};

        while ((n >>= 1) > 0) {
            if ((n & 1) == 1) a = multiply(a, r);
            r = multiply(r, r);
        }
        return (int) multiply(a, b)[0][0];
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] += a[i][k] * b[k][j] % mod;
                    c[i][j] = (c[i][j] + mod) % mod;
                }
            }
        }
        return c;
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}