import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int g = read();

        StringBuilder sb = new StringBuilder();
        int prev = 1, cur = 2, diff;
        boolean exist = false;
        while (cur <= 100_000) {
            diff = cur * cur - prev * prev;
            if (diff < g) cur++;
            else prev++;

            if (diff == g) {
                exist = true;
                sb.append(cur).append('\n');
            }
        }

        if (exist) System.out.print(sb);
        else System.out.print(-1);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}