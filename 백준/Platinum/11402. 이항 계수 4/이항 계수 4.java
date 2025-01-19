import java.io.IOException;

public class Main {
    public static int m;

    public static void main(String[] args) throws IOException {
        long n = read(), k = read();
        m = (int) read();

        int res = 1;
        while (n > 0 || k > 0) {
            res *= nCr((int) (n % m), (int) (k % m));
            res %= m;
            n /= m;
            k /= m;
        }
        System.out.println(res);
    }

    public static int nCr(int n, int r) {
        int a = 1;
        for (int i = n; i > n - r; i--) {
            a *= i;
            a %= m;
        }

        int b = 1;
        for (int i = 1; i <= r; i++) {
            b *= i;
            b %= m;
        }

        n = 1;
        r = m - 2;
        while (r != 0) {
            if ((r & 1) == 1) n = n * b % m;
            r >>= 1;
            b = b * b % m;
        }
        return a * n % m;
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}