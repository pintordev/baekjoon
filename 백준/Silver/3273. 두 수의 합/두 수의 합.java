import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        int x = read();
        int l = 0;
        int r = n - 1;
        int cnt = 0;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == x) {
                cnt++;
                l++;
                r--;
            }
            else if (sum < x) l++;
            else r--;
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