import java.io.IOException;

public class Main {
    public static char[][] image;
    public static int dr[] = {0, 0, 1, 1};
    public static int dc[] = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        int n = read();

        image = new char[n][n];
        for (int i = 0; i < n; i++) {
            image[i] = readString().toCharArray();
        }

        System.out.println(compress(0, 0, n));
    }

    public static String compress(int r, int c, int n) {
        if (n == 1) return String.valueOf(image[r][c]);

        StringBuilder sb = new StringBuilder();
        sb.append('(');
        int zero = 0, one = 0;
        int half = n >> 1;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d] * half;
            int nc = c + dc[d] * half;
            String s = compress(nr, nc, half);
            sb.append(s);
            if (s.charAt(0) == '0') zero++;
            if (s.charAt(0) == '1') one++;
        }
        if (zero == 4) return "0";
        if (one == 4) return "1";
        return sb.append(')').toString();
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}