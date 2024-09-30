import java.io.IOException;

public class Main {
    public static double sin45 = Math.sin(Math.PI / 4);
    public static double cos45 = Math.cos(Math.PI / 4);

    public static int n = 8;
    public static int[] a = new int[n];
    public static int[] seq = new int[n];
    public static boolean[] visited = new boolean[n];
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < n; i++) {
            a[i] = read();
        }

        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int depth) {
        if (depth == n) {
            if (isConvex(0) && isConvex(1)) count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            seq[depth] = a[i];
            if (depth > 1 && !isConvex(depth)) continue;

            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    public static boolean isConvex(int e) {
        int s = (e - 2 + n) % n;
        int m = (e - 1 + n) % n;

        if (seq[s] == 0 || seq[m] == 0) return true;

        double[] x = {0, seq[m] * cos45, seq[e], 0};
        double[] y = {seq[s], seq[m] * sin45, 0, seq[s]};

        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += x[i] * y[i + 1] - x[i + 1] * y[i];
        }
        return sum < 0;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}