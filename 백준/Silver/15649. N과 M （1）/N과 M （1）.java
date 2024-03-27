import java.io.IOException;

class Main {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;
    public static int[] seq;

    public static void main(String[] args) throws IOException {

        int n = read();
        int m = read();

        seq = new int[m];
        visited = new boolean[n];

        sequence(n, m, 0);
        System.out.println(sb);
    }

    private static void sequence(int n, int m, int d) {
        if (d == m) {
            for (int s : seq) sb.append(s).append(' ');
            sb.append('\n');
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