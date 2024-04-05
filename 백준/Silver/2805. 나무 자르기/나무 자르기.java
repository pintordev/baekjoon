import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        int high = 0;
        int[] woods = new int[n];
        for (int i = 0; i < n; i++) {
            woods[i] = read();
            high = Math.max(high, woods[i]);
        }

        int low = 0;
        while (low <= high) {
            int mid = (low + high) >>> 1;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (woods[i] >= mid) {
                    sum += woods[i] - mid;
                }
            }

            if (sum >= m) {
                low = mid + 1;
            } else if (sum < m) {
                high = mid - 1;
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