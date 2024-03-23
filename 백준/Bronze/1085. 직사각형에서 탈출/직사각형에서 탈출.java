import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int x = read(), y = read(), w = read(), h = read();
        System.out.println(Math.min(Math.min(x, w - x ), Math.min(y, h - y)));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}