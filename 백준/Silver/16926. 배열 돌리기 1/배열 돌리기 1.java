import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    public static int n;
    public static int m;
    public static int r;
    public static int[][] matrix;
    public static int limit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        r = Integer.parseInt(input[2]);

        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) matrix[i][j] = Integer.parseInt(input[j]);
        }

        limit = Math.min(n, m) / 2;
        rotate();

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
            Queue<Integer> queue = new LinkedList<>();
            for (int j = sj; j < ej; j++) queue.add(matrix[si][j]);
            for (int i = si; i < ei; i++) queue.add(matrix[i][ej]);
            for (int j = ej; j > sj; j--) queue.add(matrix[ei][j]);
            for (int i = ei; i > si; i--) queue.add(matrix[i][sj]);
            for (int i = 0; i < r; i++) queue.add(queue.poll());
            for (int j = sj; j < ej; j++) matrix[si][j] = queue.poll();
            for (int i = si; i < ei; i++) matrix[i][ej] = queue.poll();
            for (int j = ej; j > sj; j--) matrix[ei][j] = queue.poll();
            for (int i = ei; i > si; i--) matrix[i][sj] = queue.poll();
        }
    }
}