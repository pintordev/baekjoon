import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] memo = new int[k + 1];
        memo[0] = 1;
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= k; j++) {
                memo[j] += memo[j - coin];
            }
        }
        System.out.println(memo[k]);
    }
}