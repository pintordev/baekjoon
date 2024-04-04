import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        System.out.println(recursion(n));
    }

    public static int recursion(int n) {
        if (n <= 1 || dp[n] > 0) return dp[n];
        int min = Integer.MAX_VALUE;
        if (n % 3 == 0) min = Math.min(min, recursion(n / 3));
        if (n % 2 == 0) min = Math.min(min, recursion(n / 2));
        if (n > 1) min = Math.min(min, recursion(n - 1));
        dp[n] = min + 1;
        return dp[n];
    }
}