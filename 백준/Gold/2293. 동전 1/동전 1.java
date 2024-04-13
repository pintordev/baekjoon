import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        int[] memo = new int[k + 1];
        memo[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = read();
            for (int j = coin; j <= k; j++) {
                memo[j] += memo[j - coin];
            }
        }
        System.out.println(memo[k]);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}