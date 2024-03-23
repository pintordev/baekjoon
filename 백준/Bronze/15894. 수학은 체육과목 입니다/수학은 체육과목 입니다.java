import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        System.out.println((long) read() * 4);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}