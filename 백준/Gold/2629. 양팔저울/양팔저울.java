import java.io.IOException;

public class Main {
    public static int max = 15000;
    public static int n;
    public static int[] weights;
    public static boolean[][] memo;
    public static void main(String[] args) throws IOException {
        n = read();
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = read();
        }

        memo = new boolean[n + 1][max + 1];
        dfs(0, 0);

        int m = read();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int query = read();
            sb.append(query <= max && memo[n][query] ? 'Y' : 'N').append(' ');
        }
        System.out.println(sb);
    }

    public static void dfs(int depth, int sum) {
        if (memo[depth][sum]) return;
        memo[depth][sum] = true;
        if (depth == n) return;

        dfs(depth + 1, sum + weights[depth]);
        dfs(depth + 1, sum);
        dfs(depth + 1, Math.abs(sum - weights[depth]));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}