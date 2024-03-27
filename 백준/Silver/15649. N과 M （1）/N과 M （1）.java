import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static boolean[] visited;
    public static int[] seq;

    public static void main(String[] args) throws IOException {

        int n = read();
        int m = read();

        seq = new int[m];
        visited = new boolean[n];

        sequence(n, m, 0);
        bw.flush();
    }

    private static void sequence(int n, int m, int d) throws IOException {
        if (d == m) {
            for (int s : seq) {
                bw.write(s + 48);
                bw.write(' ');
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[d] = i + 1;
                sequence(n, m, d + 1);
                visited[i] = false;
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