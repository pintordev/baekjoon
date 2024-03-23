import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), pf = 2;
        StringBuilder sb = new StringBuilder();
        while (pf * pf <= n) {
            while (n % pf == 0) {
                sb.append(pf).append('\n');
                n /= pf;
            }
            pf++;
        }
        if (n != 1) sb.append(n);
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