import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int wanted;
    public static int m;
    public static int n;
    public static int[] a;
    public static int[] b;
    public static Map<Integer, Integer> aMap = new HashMap<>();
    public static Map<Integer, Integer> bMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        prefixSum(m, a, aMap);
        prefixSum(n, b, bMap);
        findCase();
    }

    public static void prefixSum(int len, int[] p, Map<Integer, Integer> map) {
        int[] prefixSum = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                prefixSum[j] += p[(j + i) % len];
                Integer value = map.putIfAbsent(prefixSum[j], 1);
                if (value != null) {
                    map.put(prefixSum[j], value + 1);
                }
                if (i == len - 1) {
                    break;
                }
            }
        }
    }

    public static void findCase() {
        int cnt = 0;
        for (int key : aMap.keySet()) {
            if (key == wanted) {
                cnt += aMap.get(key);
                continue;
            }
            cnt += aMap.get(key) * bMap.getOrDefault(wanted - key, 0);
        }
        cnt += bMap.getOrDefault(wanted, 0);
        System.out.println(cnt);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wanted = Integer.parseInt(br.readLine());

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
    }
}