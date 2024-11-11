import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[][] map = new int[n + 1][m + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int[] row = readIntegers(m);
            for (int j = 1; j <= m; j++) {
                if (row[j - 1] == 0) continue;
                map[i][j] = Math.min(map[i - 1][j - 1], Math.min(map[i - 1][j], map[i][j - 1])) + 1;
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max * max);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static int[] readIntegers(int m) throws IOException {
        int[] i = new int[m];
        int idx = 0, n;
        while ((n = System.in.read()) > 32) i[idx++] = n & 15;
        return i;
    }
}