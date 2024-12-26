import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_007;
    public static long[] fac = new long[4_000_001];

    public static void main(String[] args) throws IOException {
        setFac();

        StringBuilder sb = new StringBuilder();
        int m = read();
        while (m-- > 0) {
            sb.append(comb(read(), read())).append('\n');
        }
        System.out.println(sb);
    }

    public static void setFac() {
        fac[0] = 1;
        fac[1] = 1;
        for (int i = 2; i <= 4_000_000; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }
    }

    public static long comb(int n, int k) {
        return (fac[n] * pow((fac[k] * fac[n - k]) % mod, mod - 2)) % mod;
    }

    public static long pow(long n, int k) {
        long base = 1;
        while (k > 0) {
            if (k % 2 == 1) base = (base * n) % mod;
            n = (n * n) % mod;
            k >>= 1;
        }
        return base;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}