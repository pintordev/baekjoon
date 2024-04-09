import java.io.IOException;

class Main {
    public static int n;
    public static int[] stairs;
    public static int[] memo;

    public static void main(String[] args) throws IOException {
        readStairs();
        dpInit();
        dp(n);
        System.out.println(memo[n]);
    }

    public static void dp(int i) {
        if (memo[i] > 0 || i < 3) return;
        dp(i - 2);
        dp(i - 3);
        memo[i] = stairs[i] + Math.max(stairs[i - 1] + memo[i - 3], memo[i - 2]);
    }

    public static void dpInit() {
        memo = new int[n + 1];
        memo[1] = stairs[1];
        if (n < 2) return;
        memo[2] = stairs[1] + stairs[2];
    }

    public static void readStairs() throws IOException {
        n = read();
        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = read();
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}