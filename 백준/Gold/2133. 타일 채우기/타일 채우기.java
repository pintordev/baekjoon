import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[2] = 3;

        int sum = memo[0];
        for (int i = 4; i <= n; i += 2) {
            memo[i] = memo[i - 2] * memo[2] + 2 * sum;
            sum += memo[i - 2];
        }
        System.out.println(memo[n]);
    }
}