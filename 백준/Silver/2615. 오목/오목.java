import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int[][] board = new int[19][19];
    public static int[][] ds = {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        for (int i = 0; i < 19; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) board[i][j] = Integer.parseInt(input[j]);
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    if (check(i, j, k) && count(i, j, k) == 5) {
                        System.out.println(new StringBuilder()
                                .append(board[i][j]).append('\n')
                                .append(i + 1).append(' ').append(j + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static int count(int i, int j, int k) {

        int ni = i + ds[k][0];
        int nj = j + ds[k][1];

        if (ni < 0 || ni >= 19 || nj < 0 || nj >= 19) return 1;
        if (board[i][j] != board[ni][nj]) return 1;
        return count(ni, nj, k) + 1;
    }

    public static boolean check(int i, int j, int k) {

        int ni = i - ds[k][0];
        int nj = j - ds[k][1];

        if (ni < 0 || ni >= 19 || nj < 0 || nj >= 19) return true;
        if (board[i][j] != board[ni][nj]) return true;
        return false;
    }
}