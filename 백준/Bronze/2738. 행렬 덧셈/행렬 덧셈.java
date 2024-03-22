import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), m = read();
        int[][] matrix = new int[n][m];
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] += read();
                    if (k > 0) sb.append(matrix[i][j]).append(' ');
                }
                if (k > 0) sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}