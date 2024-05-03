import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        int low = 1;
        int high = k;
        while (low + 1 < high) {
            int mid = (low + high) / 2;

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        
        System.out.println(high);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}