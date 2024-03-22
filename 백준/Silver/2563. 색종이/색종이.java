import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();

        boolean[][] visited = new boolean[100][100];
        int count = 0;
        while (n-- > 0) {
            int w = read(), h = read();
            for (int i = w; i < w + 10; i++) {
                for (int j = h; j < h + 10; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}