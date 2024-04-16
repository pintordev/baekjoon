import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        Arrays.sort(arr);

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += diff[i];
        }
        System.out.println(sum);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}