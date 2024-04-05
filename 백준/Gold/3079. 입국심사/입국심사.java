import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] times = new int[n];
        long high = 0;
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
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
}