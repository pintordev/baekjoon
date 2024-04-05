import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int c = read();

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = read();
        }

        Arrays.sort(houses);

        long low = 0;
        long high = houses[n - 1] - houses[0];
        long mid = 0;
        while (low <= high) {
            mid = (low + high) >>> 1;

            int cnt = 1;
            int pre = houses[0];
            for (int i = 1; i < n; i++) {
                if (houses[i] - pre >= mid) {
                    cnt++;
                    pre = houses[i];
                }
            }

            if (cnt >= c) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(low - 1);
    }
    
    public static int read() throws IOException {
    int c, n = System.in.read() & 15;
    while ((c = System.in.read()) > 32) {
        n = (n << 3) + (n << 1) + (c & 15);
    }
    return n;
}
}