import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int[] dp = new int[3];
        int[] temp = new int[3];
        for (int i = 0; i < n; i++) {
            temp[0] = Math.min(dp[1], dp[2]) + read();
            temp[1] = Math.min(dp[0], dp[2]) + read();
            temp[2] = Math.min(dp[0], dp[1]) + read();
            dp = temp.clone();
        }
        System.out.println(Math.min(Math.min(dp[0], dp[1]), dp[2]));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}