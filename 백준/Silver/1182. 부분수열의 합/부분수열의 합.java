import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static int n;
    public static int s;
    public static int[] num;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(input[i]);
        }

        dfs(0, 0);
        if (s == 0) {
            System.out.println(cnt - 1);
        } else {
            System.out.println(cnt);
        }
    }

    public static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum == s) {
                cnt++;
            }
            return;
        }

        dfs(idx + 1, sum + num[idx]);
        dfs(idx + 1, sum);
    }
}