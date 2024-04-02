import java.io.IOException;

class Main {

    public static long[] p;

    public static void main(String[] args) throws IOException {

        p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) sb.append(p(read())).append('\n');
        System.out.println(sb);
    }

    public static long p(int n) {
        if (p[n] > 0) return p[n];
        p[n] = p(n - 1) + p(n - 5);
        return p[n];
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}