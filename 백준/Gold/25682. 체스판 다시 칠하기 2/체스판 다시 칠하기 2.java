import java.io.IOException;

public class Main {
    public static int[][] black;
    public static int[][] white;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();
        int k = read();

        black = new int[n + 1][m + 1];
        white = new int[n + 1][m + 1];

        String s;
        for (int i = 1; i <= n; i++) {
            s = readString();
            for (int j = 1; j <= m; j++) {
                black[i][j] = black[i - 1][j] + black[i][j - 1] - black[i - 1][j - 1];
                white[i][j] = white[i - 1][j] + white[i][j - 1] - white[i - 1][j - 1];

                boolean isMajor = (i + j) % 2 == 0;
                boolean isBlack = s.charAt(j - 1) == 'B';

                if (isMajor ^ isBlack) white[i][j]++;
                else black[i][j]++;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                int b = black[i + k][j + k] - black[i][j + k] - black[i + k][j] + black[i][j];
                int w = white[i + k][j + k] - white[i][j + k] - white[i + k][j] + white[i][j];
                min = Math.min(min, Math.min(b, w));
            }
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

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}