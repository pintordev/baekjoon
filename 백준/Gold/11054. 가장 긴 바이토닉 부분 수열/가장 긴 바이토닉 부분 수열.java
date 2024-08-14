import java.io.IOException;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[][] memo;

    public static void main(String[] args) throws IOException {
        n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        memo = new int[2][n];
        lis();
        lds();

        System.out.println(max());
    }

    public static void lis() {
        int[] lis = new int[n];
        lis[0] = arr[0];
        int idx = 0;
        for (int i = 1; i < n; i++) {
            int num = arr[i];
            if (lis[idx] < num) {
                lis[++idx] = num;
                memo[0][i] = idx;
                continue;
            }

            int low = 0;
            int high = idx;
            while (low + 1 < high) {
                int mid = (low + high) >> 1;
                if (lis[mid] < num) low = mid;
                else high = mid;
            }

            if (lis[low] >= num) {
                lis[low] = num;
                memo[0][i] = low;
            } else {
                lis[high] = num;
                memo[0][i] = high;
            }
        }
    }

    public static void lds() {
        int[] lds = new int[n];
        lds[0] = arr[n - 1];
        int idx = 0;
        for (int i = n - 2; i >= 0; i--) {
            int num = arr[i];
            if (lds[idx] < num) {
                lds[++idx] = num;
                memo[1][i] = idx;
                continue;
            }

            int low = 0;
            int high = idx;
            while (low + 1 < high) {
                int mid = (low + high) >> 1;
                if (lds[mid] < num) low = mid;
                else high = mid;
            }

            if (lds[low] >= num) {
                lds[low] = num;
                memo[1][i] = low;
            } else {
                lds[high] = num;
                memo[1][i] = high;
            }
        }
    }

    public static int max() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, memo[0][i] + memo[1][i]);
        }
        return max + 1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}