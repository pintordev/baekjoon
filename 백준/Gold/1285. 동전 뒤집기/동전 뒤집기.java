import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        char[][] map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = readChars(n);
        }

        int min = Integer.MAX_VALUE;
        for (int bit = 0; bit < (1 << n); bit++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int back = 0;
                for (int j = 0; j < n; j++) {
                    char cur = map[i][j];
                    if ((bit & (1 << j)) != 0) cur = cur == 'H' ? 'T' : 'H';
                    if (cur == 'T') back++;
                }
                cnt += Math.min(back, n - back);
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return c;
    }
}