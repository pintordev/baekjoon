import java.io.IOException;

class Main {

    public static char[][] c;
    public static char[][] base = {{'*', '*', '*'}, {'*', ' ', '*'}, {'*', '*', '*'}};

    public static void main(String[] args) throws IOException {

        int n = read();
        c = new char[n][n];
        star(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(c[i]).append('\n');
        System.out.println(sb);
    }

    public static void star(int n, int i, int j) {

        if (n == 3) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    c[i + x][j + y] = base[x][y];
                }
            }
            return;
        }

        for (int x = 0; x < n; x += n / 3) {
            for (int y = 0; y < n; y += n / 3) {
                if (x == n / 3 && y == n / 3) blank(n / 3, i + x, j + y);
                else star(n / 3, i + x, j + y);
            }
        }
    }

    public static void blank(int n, int i, int j) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                c[i + x][j + y] = ' ';
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}