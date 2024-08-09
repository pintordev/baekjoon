import java.io.IOException;

public class Main {
    public static int[][][] papers;
    public static int[] numbers;
    public static int[] dr = {0, 0, 0, 1, 1, 1, 2, 2, 2};
    public static int[] dc = {0, 1, 2, 0, 1, 2, 0, 1, 2};

    public static void main(String[] args) throws IOException {
        int n = read();
        papers = new int[3][n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int num = read();
                for (int k = 0; k < 3; k++) {
                    papers[k][i][j] = (num == k - 1 ? 1 : 0) + papers[k][i - 1][j] + papers[k][i][j - 1] - papers[k][i - 1][j - 1];
                }
            }
        }

        numbers = new int[3];
        count(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(numbers[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void count(int r, int c, int n) {
        for (int i = 0; i < 3; i++) {
            int num = papers[i][r + n][c + n] - papers[i][r][c + n] - papers[i][r + n][c] + papers[i][r][c];
            if (num == n * n) {
                numbers[i]++;
                return;
            }
        }

        int nn = n / 3;
        for (int i = 0; i < 9; i++) {
            count(r + dr[i] * nn, c + dc[i] * nn, nn);
        }
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