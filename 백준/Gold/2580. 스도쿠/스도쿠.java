import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        for (int i = 0; i < 9; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) board[i][j] = Integer.parseInt(input[j]);
        }

        put(0, 0);
    }

    public static void put(int r, int c) {

        if (c == 9) {
            r++;
            c = 0;
        }

        if (r == 9) print();

        if (board[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!canPut(r, c, i)) continue;
                board[r][c] = i;
                put(r, c + 1);
            }
            board[r][c] = 0;
            return;
        }

        put(r, c + 1);
    }

    public static boolean canPut(int r, int c, int n) {

        for (int j = 0; j < 9; j++) {
            if (board[r][j] == n) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][c] == n) return false;
        }

        int si = r - r % 3, sj = c - c % 3;
        int ei = si + 3, ej = sj + 3;
        for (int i = si; i < ei; i++) {
            for (int j = sj; j < ej; j++) {
                if (board[i][j] == n) return false;
            }
        }

        return true;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) sb.append(board[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
        System.exit(0);
    }
}