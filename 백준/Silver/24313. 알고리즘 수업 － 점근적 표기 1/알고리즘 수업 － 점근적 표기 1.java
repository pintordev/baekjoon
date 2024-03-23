import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int a1 = read(), a0 = read(), c = read(), n0 = read();
        if (a1 <= c && a1 * n0 + a0 <= c * n0) System.out.println(1);
        else System.out.println(0);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = (n == 13);
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? -1 * n : n;
    }
}