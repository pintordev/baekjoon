import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), bag = Integer.MAX_VALUE;
        for (int i = n / 5; i >= 0; i--) {
            for (int j = (n - 5 * i) / 3; j >=0; j--) {
                if (i * 5 + j * 3 == n) bag = Math.min(bag, i + j);
            }
        }
        if (bag == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(bag);
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