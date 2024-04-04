import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] u = new int[n];
        for (int i = 0; i < n; i++) {
            u[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(u);

        Set<Integer> xy = new HashSet<>();
        for (int x : u) {
            for (int y : u) {
                xy.add(x + y);
            }
        }

        for (int k = n - 1; k >= 0; k--) {
            for (int z : u) {
                if (xy.contains(u[k] - z)) {
                    System.out.println(u[k]);
                    return;
                }
            }
        }
    }
}