import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        System.out.println((int) Math.pow(2, n));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}