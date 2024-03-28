import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        while (true) {
            int a =read(), b = read(), c = read();
            if (a == 0 && b == 0 && c == 0) break;

            int[] lines = {a, b, c};
            Arrays.sort(lines);
            if (lines[0] * lines[0] + lines[1] * lines[1] == lines[2] * lines[2]) sb.append("right").append('\n');
            else sb.append("wrong").append('\n');
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