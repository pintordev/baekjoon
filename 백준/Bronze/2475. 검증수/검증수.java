import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        long sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = read();
            sum += (long) n * n;
        }
        System.out.println(sum % 10);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}