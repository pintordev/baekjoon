import java.io.IOException;

public class Main {
    public static int n = 18;
    public static boolean[] complex;
    public static double[][][] memo;

    public static void main(String[] args) throws IOException {
        init();
        setMemo(read() / 100.0, read() / 100.0);
        System.out.println(getProbability());
    }

    public static void init() {
        complex = new boolean[n + 1];
        complex[0] = complex[1] = true;
        for (int i = 2; i <= n; i++) {
            if (complex[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                complex[j] = true;
            }
        }
    }

    public static void setMemo(double a, double b) {
        memo = new double[n + 1][n + 1][n + 1];
        memo[0][0][0] = 1.0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (j > 0) memo[i][j][k] += memo[i - 1][j - 1][k] * a * (1 - b);
                    if (k > 0) memo[i][j][k] += memo[i - 1][j][k - 1] * (1 - a) * b;
                    if (j > 0 && k > 0) memo[i][j][k] += memo[i - 1][j - 1][k - 1] * a * b;
                    memo[i][j][k] += memo[i - 1][j][k] * (1 - a) * (1 - b);
                }
            }
        }
    }

    public static double getProbability() {
        double result = 0.0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (!complex[i] || !complex[j]) result += memo[n][i][j];
            }
        }
        return result;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}