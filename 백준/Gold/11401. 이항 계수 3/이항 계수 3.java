import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        long a = 1, b, c;
        int min = Math.min(n - k, k);
        int max = Math.max(n - k, k);
        for (int i = 1; i <= min; i++) {
            a = a * i % mod;
        }
        b = a;
        for (int i = min + 1; i <= max; i++) {
            b = b * i % mod;
        }
        c = b;
        for (int i = max + 1; i <= n; i++) {
            c = c * i % mod;
        }

        System.out.println(c * pow(a * b % mod, mod - 2) % mod);
    }

    public static long pow(long n, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * n % mod;
            }
            n = n * n % mod;
            exp /= 2;
        }
        return result;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}