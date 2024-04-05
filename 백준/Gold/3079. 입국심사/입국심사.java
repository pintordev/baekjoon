import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int[] times = new int[n];
        long high = 0;
        for (int i = 0; i < n; i++) {
            times[i] = read();
            high = Math.max(high, times[i]);
        }

        Arrays.sort(times);

        long low = 0;
        high *= m;
        while (low <= high) {
            long mid = (low + high) >>> 1;

            long cnt = 0;
            for (int i = 0; i < n && cnt <= m; i++) {
                cnt += mid / times[i];
            }

            if (cnt < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}