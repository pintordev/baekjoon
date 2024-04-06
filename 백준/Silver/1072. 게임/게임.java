import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        long z = y * 100 / x;

        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        long low = 0;
        long high = 1000000000;
        while (low + 1 < high) {
            long mid = (low + high) >>> 1;
            long nz = (y + mid) * 100 / (x + mid);

            if (nz <= z) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(high);
    }
}