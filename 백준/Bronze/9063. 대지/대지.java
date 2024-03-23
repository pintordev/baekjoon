import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int minX = -10000, minY = -10000, maxX = 10000, maxY= 10000;
        while (n-- > 0) {
            int x = read(), y = read();
            minX = Math.max(minX, x);
            minY = Math.max(minY, y);
            maxX = Math.min(maxX, x);
            maxY = Math.min(maxY, y);
        }
        System.out.println((maxX - minX) * (maxY - minY));
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