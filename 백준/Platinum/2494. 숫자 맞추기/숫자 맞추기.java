import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int INF = Integer.MAX_VALUE;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = read();
        int[] cur = readIntArr(n + 1);
        int[] target = readIntArr(n + 1);

        int[][] memo = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            memo[0][i] = i;
        }
        Log[][] logs = new Log[n + 1][10];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(memo[i], INF);
            for (int j = 0; j < 10; j++) {
                int lCnt = (target[i] - cur[i] + 20 - j) % 10;
                int rCnt = 10 - lCnt;

                if (memo[i - 1][j] == INF) continue;

                if (memo[i][j] > memo[i - 1][j] + rCnt) {
                    memo[i][j] = memo[i - 1][j] + rCnt;
                    logs[i][j] = new Log(i, -rCnt, logs[i - 1][j]);
                }

                if (memo[i][(j + lCnt) % 10] > memo[i - 1][j] + lCnt) {
                    memo[i][(j + lCnt) % 10] = memo[i - 1][j] + lCnt;
                    logs[i][(j + lCnt) % 10] = new Log(i, lCnt, logs[i - 1][j]);
                }
            }
        }

        int min = INF;
        Log log = null;
        for (int i = 0; i < 10; i++) {
            if (min > memo[n][i]) {
                min = memo[n][i];
                log = logs[n][i];
            }
        }
        sb.append(min).append('\n');

        trace(log);
        System.out.println(sb);
    }

    public static void trace(Log log) {
        if (log == null) return;
        trace(log.pre);
        sb.append(log.num).append(' ').append(log.cnt).append('\n');
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

class Log {
    int num;
    int cnt;
    Log pre;

    public Log(int num, int cnt, Log pre) {
        this.num = num;
        this.cnt = cnt;
        this.pre = pre;
    }
}