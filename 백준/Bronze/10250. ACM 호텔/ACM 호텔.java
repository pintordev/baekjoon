import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int h = read(), w = read(), n = read();
            sb.append(100 * ((n - 1) % h + 1) + (n - 1) / h + 1).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}