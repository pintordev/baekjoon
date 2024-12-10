import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int gcd = read();
        int lcm = read();

        long m = (long) gcd * lcm;
        for (int i = (int) Math.sqrt(m) / gcd * gcd; i >= gcd; i -= gcd) {
            if (m % i != 0 || gcd(i, m / i) != gcd) continue;
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(' ').append(m / i);
            System.out.println(sb);
            return;
        }
    }

    public static long gcd(long a, long b) {
        long r = a % b;
        return r == 0 ? b : gcd(b, r);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}