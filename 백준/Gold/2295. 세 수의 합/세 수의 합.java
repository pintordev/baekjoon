import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(u);

        int[] xy = new int[n * n];
        int idx = 0;
        for (int x : u) {
            for (int y : u) {
                xy[idx++] = x + y;
            }
        }
        Arrays.sort(xy);

        for (int k = n - 1; k >= 0; k--) {
            for (int z : u) {
                if (Arrays.binarySearch(xy, u[k] - z) >= 0) {
                    System.out.println(u[k]);
                    return;
                }
            }
        }
    }
}