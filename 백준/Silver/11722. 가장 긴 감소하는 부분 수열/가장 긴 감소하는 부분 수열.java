import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] memo = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }
        System.out.println(max);
    }
}