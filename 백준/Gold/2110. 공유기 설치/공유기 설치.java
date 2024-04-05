import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[] houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
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
}