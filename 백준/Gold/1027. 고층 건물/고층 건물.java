import java.io.IOException;

public class Main {
    public static int INF = 1_000_000_000;
    
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;

            double slope = INF;
            for (int j = i - 1; j >= 0; j--) {
                double cur = (double) (arr[i] - arr[j]) / (i - j);
                if (cur >= slope) continue;
                cnt++;
                slope = cur;
            }

            slope = -INF;
            for (int j = i + 1; j < n; j++) {
                double cur = (double) (arr[j] - arr[i]) / (j - i);
                if (cur <= slope) continue;
                cnt++;
                slope = cur;
            }

            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}