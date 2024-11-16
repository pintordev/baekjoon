import java.io.IOException;

public class Main {
    public static int mod = 1_000_000;
    public static long[][] b = new long[][]{{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        System.out.println(fibonacci(read())[0][1]);
    }

    public static long[][] fibonacci(long n) {
        if (n == 1) return b;
        long[][] m = fibonacci(n >> 1);
        m = matMul(m, m);
        return n % 2 == 0 ? m : matMul(m, b);
    }

    public static long[][] matMul(long[][] m1, long[][] m2) {
        long[][] m = new long[2][2];
        m[0][0] = (m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % mod;
        m[0][1] = (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % mod;
        m[1][0] = (m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % mod;
        m[1][1] = (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % mod;
        return m;
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}