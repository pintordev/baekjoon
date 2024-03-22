import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), i = 2;
        while (n-- > 0) i = 2 * i - 1;
        System.out.println(i * i);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}