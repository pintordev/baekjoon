import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int l = 2 * n - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= l; i++) {
            int f = n - Math.abs(n - i);
            for (int j = 1; j < n + f; j++) {
                if (n - j >= f) sb.append(' ');
                else sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {

        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) != 10) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}