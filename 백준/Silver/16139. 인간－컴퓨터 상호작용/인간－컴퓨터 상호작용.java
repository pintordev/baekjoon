import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] s = readChars();
        int n = s.length;

        int[][] memo = new int[26][n + 1];
        for (int j = 1; j <= n; j++) {
            int c = s[j - 1] - 'a';
            for (int i = 0; i < 26; i++) {
                memo[i][j] = memo[i][j - 1] + (c == i ? 1 : 0);
            }
        }

        StringBuilder sb = new StringBuilder();
        int q = read();
        while (q-- > 0) {
            int a = readChar();
            int l = read();
            int r = read() + 1;
            sb.append(memo[a][r] - memo[a][l]).append('\n');
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

    public static int readChar() throws IOException {
        int n = System.in.read();
        if (n <= 32) n = System.in.read();
        return n - 'a';
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[200000];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}