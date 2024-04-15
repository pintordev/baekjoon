import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int order;
    public static int m;
    public static int n;
    public static int[] a;
    public static int[] b;
    public static int[] aMap;
    public static int[] bMap;

    public static void main(String[] args) throws IOException {
        init();
        prefixSum(m, a, aMap);
        prefixSum(n, b, bMap);
        findCase();
    }

    public static void prefixSum(int len, int[] p, int[] map) {
        int[] prefixSum = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                prefixSum[j] += p[(j + i) % len];
                if (prefixSum[j] <= order) {
                    map[prefixSum[j]]++;
                }
            }
        }
        if (prefixSum[0] + p[len - 1] <= order) {
            map[prefixSum[0] + p[len - 1]]++;
        }
    }

    public static void findCase() {
        int cnt = 0;
        for (int i = 0; i <= order; i++) {
            cnt += aMap[i] * bMap[order - i];
        }
        System.out.println(cnt);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        order = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(br.readLine());
        }

        aMap = new int[order + 1];
        bMap = new int[order + 1];
        aMap[0] = 1;
        bMap[0] = 1;
    }
}