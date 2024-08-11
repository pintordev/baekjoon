import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;
    public static long[][] f = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        long n = read();
        System.out.println(pow(n)[1][0]);
    }

    public static long[][] pow(long n) {
        long[][] a = {{1, 0}, {0, 1}};
        while (n > 0) {
            if (n % 2 == 1) a = mul(a, f);
            f = mul(f, f);
            n /= 2;
        }
        return a;
    }

    public static long[][] mul(long[][] a, long[][] f) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] += a[i][k] * f[k][j];
                }
                c[i][j] %= mod;
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