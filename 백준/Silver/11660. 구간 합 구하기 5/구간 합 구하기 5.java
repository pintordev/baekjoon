import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), m = read();
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + read();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int x1 = read(), y1 = read(), x2 = read(), y2 = read();
            int diff = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];
            sb.append(diff).append('\n');
        }
        System.out.print(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}