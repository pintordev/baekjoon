import java.io.IOException;

public class Main {
    public static int len;
    public static long[] memo;

    public static void main(String[] args) throws IOException {
        long a = read();
        long b = read();

        init(b);
        System.out.println(count(b) - count(a - 1));
    }

    public static long count(long n) {
        long cnt = n & 1;
        for (int i = len - 1; i > 0; i--) {
            if ((n & (1L << i)) == 0) continue;
            cnt += memo[i - 1] + (n - (1L << i) + 1);
            n -= (1L << i);
        }
        return cnt;
    }

    public static void init(long n) {
        len = log2(n) + 1;
        memo = new long[len];
        memo[0] = 1;
        for (int i = 1; i < len; i++) {
            memo[i] = (memo[i - 1] << 1) + (1L << i);
        }
    }

    public static int log2(long n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}