import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = read(), b = read();
            if (a == 0 && b == 0) break;
            if (b % a == 0) sb.append("factor").append('\n');
            else if (a % b == 0) sb.append("multiple").append('\n');
            else sb.append("neither").append('\n');
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