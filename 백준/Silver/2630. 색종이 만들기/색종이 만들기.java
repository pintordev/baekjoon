import java.io.IOException;

class Main {
    public static int[][] paper;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        int n = read();
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = read();
            }
        }

        divide(0, 0, n);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    public static void divide(int r, int c, int n) {
        if (hasSameColor(r, c, n)) {
            if (paper[r][c] == 0) white++;
            else blue++;
            return;
        }

        int half = n / 2;
        divide(r, c, half);
        divide(r, c + half, half);
        divide(r + half, c, half);
        divide(r + half, c + half, half);
    }

    public static boolean hasSameColor(int r, int c, int n) {
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (paper[r][c] != paper[i][j]) return false;
            }
        }
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}