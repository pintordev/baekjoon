import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int a = read(), b = read(), c = read(), d = read(), e = read(), f = read();
        int base = a * e - b * d;
        StringBuilder sb = new StringBuilder();
        sb.append((c * e - b * f) / base).append(' ')
                .append((a * f - c * d)/ base);
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}