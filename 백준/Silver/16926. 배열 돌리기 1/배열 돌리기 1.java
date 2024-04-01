import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int n;
    public static int m;
    public static int[][] matrix;
    public static int limit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) matrix[i][j] = Integer.parseInt(input[j]);
        }

        limit = Math.min(n, m) / 2;
        for (int i = 0; i < r; i++) rotate();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) sb.append(matrix[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void rotate() {
        for (int k = 0; k < limit; k++) {
            int si = k, sj = k, ei = n - k - 1, ej = m - k - 1;
            int mode = 1, hold = matrix[si][sj], i = si, j = sj;

            while (mode < 5) {
                if (mode == 1 && ++i == ei) mode++;
                else if (mode == 2 && ++j == ej) mode++;
                else if (mode == 3 && --i == si) mode++;
                else if (mode == 4 && --j == sj) mode++;

                int temp = matrix[i][j];
                matrix[i][j] = hold;
                hold = temp;
            }
        }
    }
}