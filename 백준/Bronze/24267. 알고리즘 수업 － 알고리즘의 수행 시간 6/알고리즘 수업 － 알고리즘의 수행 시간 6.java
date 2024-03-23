import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        long n = read();
        System.out.println(n * (n - 1) * (n - 2) / 6);
        System.out.println(3);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}