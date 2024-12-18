import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int m = read();

        int n, s;
        long res = 0;
        while (m-- > 0) {
            n = read();
            s = read();

            int gcd = gcd(Math.max(n, s), Math.min(n, s));
            n /= gcd;
            s /= gcd;

            res += s * find(n, mod - 2) % mod;
            res %= mod;
        }
        System.out.println(res);
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static long find(long a, long b) {
        if (b == 1) return a;

        long c = find(a, b / 2);
        long res = c * c % mod;
        if (b % 2 == 0) return res;
        return res * a % mod;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}