import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[] memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = read();
        }

        int[] cost = new int[n];
        int maxCost = 0;
        for (int i = 0; i < n; i++) {
            cost[i] = read();
            maxCost += cost[i];
        }

        int[] memo = new int[maxCost + 1];
        for (int i = 0; i < n; i++) {
            for (int j = maxCost; j >= cost[i]; j--) {
                memo[j] = Math.max(memo[j], memo[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= maxCost; i++) {
            if (memo[i] >= m) {
                System.out.println(i);
                break;
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