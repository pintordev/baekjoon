import java.io.IOException;

public class Main {
    public static int[] cards;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = read();

            cards = new int[n];
            for (int i = 0; i < n; i++) {
                cards[i] = read();
            }

            dp = new int[n + 1][n + 1];
            getMax(0, n - 1, true);
            sb.append(dp[0][n - 1]).append('\n');
        }
        System.out.print(sb);
    }

    public static int getMax(int l, int r, boolean b) {
        if (l > r) return 0;
        if (dp[l][r] != 0) return dp[l][r];
        if (b) return dp[l][r] = Math.max(cards[l] + getMax(l + 1, r, false), cards[r] + getMax(l, r - 1, false));
        else return dp[l][r] = Math.min(getMax(l + 1, r, true), getMax(l, r - 1, true));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}