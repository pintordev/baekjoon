import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long n = read();

        long res = n;
        for (long k = 2; k * k <= n; k++) {
            if (n % k != 0) continue;
            res -= res / k;
            while (n % k == 0) {
                n /= k;
            }
        }

        if (n > 1) res -= res / n;
        System.out.println(res);
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}