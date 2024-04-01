import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int n;
    public static int m;
    public static char[][] board;
    public static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        board = new char[n][m];
        for (int i = 0; i < n; i++) board[i] = br.readLine().toCharArray();

        min = n * m;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                repaint(i, j);
            }
        }

        System.out.println(min);
    }

    public static void repaint(int si, int sj) {

        int w = 0;
        int b = 0;
        for (int i = si; i < si + 8; i++) {
            for (int j = sj; j < sj + 8; j++) {
                int k = (i + j - si - sj) % 2;
                if (board[i][j] == 'W' && k == 0) b++;
                else if (board[i][j] == 'W' && k == 1) w++;
                else if (board[i][j] == 'B' && k == 1) b++;
                else w++;
            }
        }
        min = Math.min(min, Math.min(w, b));
    }
}