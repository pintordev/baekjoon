import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int s = read(), p = read(), e = read();
        int gcd = gcd(p - s, e - p);
        int idx = n - 3;
        while (idx-- > 0) {
            e = read();
            gcd = gcd(gcd, e - p);
            p = e;
        }
        System.out.println((e - s) / gcd + 1 - n);
    }

    public static int gcd(int a, int b) {
        int min = Math.min(a, b), max = Math.max(a, b);
        while (max % min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}