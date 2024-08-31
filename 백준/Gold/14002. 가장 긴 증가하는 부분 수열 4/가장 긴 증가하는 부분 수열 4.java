import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int[] dp = new int[n];
        int len = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
                len = Math.max(len, dp[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(len).append('\n');
        int size = sb.length();
        for (int i = n - 1; i >= 0 && len > 0; i--) {
            if (dp[i] != len) continue;
            sb.insert(size, arr[i] + " ");
            len--;
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