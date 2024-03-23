import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        boolean[] b = new boolean[2000001];
        for (int i = 0; i < n; i++) b[read() + 1000000] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = -1000000; i <= 1000000; i++) {
            if (b[i + 1000000]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}