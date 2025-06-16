import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        long n = read();
        long a = read();

        long b = n - a;
        sb.append(b).append(' ');

        if (gcd(a, b) != 1) sb.append("-1");
        else {
            long[] res = execute(a, n);

            while (res[0] < 0) {
                res[0] += n;
            }

            sb.append(res[0]);
        }

        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static long[] execute(long a, long b) {
        if (b == 0) return new long[]{1, 0};
        long[] res = execute(b, a % b);
        return new long[]{res[1], res[0] - res[1] * (a / b)};
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}