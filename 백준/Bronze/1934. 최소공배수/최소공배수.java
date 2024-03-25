import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int a = read(), b = read();
            int min = Math.min(a, b), max = Math.max(a, b);
            int gcd = 0;
            for (int i = 1; i * i <= min; i++) {
                if (min % i != 0) continue;
                if (max % i == 0) gcd = Math.max(gcd, i);
                if (max % (min / i) == 0) gcd = Math.max(gcd, min / i);
            }
            sb.append(min * max / gcd).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}