import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int count = 0;
        for (int i = 1; i * i <= n; i++) count++;
        System.out.println(count);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}