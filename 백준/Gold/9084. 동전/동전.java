import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] coins = new int[n];
            String input[] = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(input[i]);
            }

            int m = Integer.parseInt(br.readLine());
            int[] memo = new int[m + 1];
            memo[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    memo[j] += memo[j - coins[i]];
                }
            }
            sb.append(memo[m]).append('\n');
        }
        System.out.println(sb);
    }
}