import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int n = read();
        int[] cur = readIntArr(n + 1);
        int[] target = readIntArr(n + 1);

        int[][] memo = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            memo[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(memo[i], INF);
            for (int j = 0; j < 10; j++) {
                int lCnt = (target[i] - cur[i] + 20 - j) % 10;
                int rCnt = 10 - lCnt;
                memo[i][j] = Math.min(memo[i][j], memo[i - 1][j] + rCnt);
                memo[i][(j + lCnt) % 10] = Math.min(memo[i][(j + lCnt) % 10], memo[i - 1][j] + lCnt);
            }
        }

        int min = INF;
        for (int i = 0; i < 10; i++) {
            min = Math.min(min, memo[n][i]);
        }
        System.out.println(min);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static int[] readIntArr(int len) throws IOException {
        int[] arr = new int[len];
        for (int i = 1; i < len; i++) {
            arr[i] = System.in.read() & 15;
        }
        System.in.read();
        return arr;
    }
}