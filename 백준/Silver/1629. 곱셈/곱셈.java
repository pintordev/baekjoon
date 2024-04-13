import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int a = read(), b = read(), c = read();
        System.out.println(half(a, b, c));
    }

    public static long half(long a, long b, long c) {
        if (b == 1) return a % c;
        long half = half(a, b / 2, c);
        if (b % 2 == 0) return half * half % c;
        return (half * half % c) * (a % c) % c;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}