import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] memory = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(input[i]);
        }

        int[] cost = new int[n];
        int maxCost = 0;
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(input[i]);
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
}