import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_000;
    public static long[][] base = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        long a = read(), b = read();

        long[][] am = pow(a + 1);
        long[][] bm = pow(b + 2);
        System.out.println((bm[0][1] - am[0][1] + mod) % mod);
    }

    public static long[][] pow(long a) {
        if (a == 1) return base;
        long[][] half = pow(a / 2);
        return a % 2 == 0 ? mul(half, half) : mul(mul(half, half), base);
    }

    public static long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        c[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
        c[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
        c[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
        c[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;
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