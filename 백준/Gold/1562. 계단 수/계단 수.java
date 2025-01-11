import java.io.IOException;

public class Main {
    public static int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        int n = read();

        long[][][] memo = new long[n + 1][10][1 << 10];
        for (int i = 1; i < 10; i++) {
            memo[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1 << 10; k++) {
                    int bit = k | 1 << j;
                    if (j == 0) memo[i][j][bit] += memo[i - 1][j + 1][k];
                    else if (j == 9) memo[i][j][bit] += memo[i - 1][j - 1][k];
                    else memo[i][j][bit] += memo[i - 1][j - 1][k] + memo[i - 1][j + 1][k];
                    memo[i][j][k | 1 << j] %= mod;
                }
            }
        }

        long cnt = 0;
        for (int i = 0; i < 10; i++) {
            cnt += memo[n][i][1023];
            cnt %= mod;
        }
        System.out.println(cnt);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}