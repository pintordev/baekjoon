import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int high = 0;
        int[] woods = new int[n];
        for (int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(input[i]);
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
}