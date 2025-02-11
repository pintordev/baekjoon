import java.io.IOException;

public class Main {
    public static int n;
    public static int[] honey;

    public static void main(String[] args) throws IOException {
        n = read();
        honey = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            honey[i] = read();
        }

        System.out.println(Math.max(left(), Math.max(mid(), right())));
    }

    public static int left() {
        int[] sum = new int[n + 1];
        for (int i = n - 1; i >= 1; i--) {
            sum[i] = sum[i + 1] + honey[i + 1];
        }

        int s = sum[1];
        int max = 0;
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, s - honey[i]+ sum[i]);
        }
        return max;
    }

    public static int mid() {
        int[] leftSum = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            leftSum[i] = leftSum[i - 1] + honey[i];
        }

        int[] rightSum = new int[n + 1];
        for (int i = n - 1; i >= 1; i--) {
            rightSum[i] = rightSum[i + 1] + honey[i];
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, leftSum[i] + rightSum[i]);
        }
        return max;
    }

    public static int right() {
        int[] sum = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + honey[i - 1];
        }

        int s = sum[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, s - honey[i] + sum[i]);
        }
        return max;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}