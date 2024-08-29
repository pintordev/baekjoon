import java.io.IOException;
import java.util.*;

public class Main {
    public static int[] arr;
    public static List<Integer>[] candidate;

    public static void main(String[] args) throws IOException {
        int n = read();
        int c = read();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        candidate = new List[2];
        for (int i = 0; i < 2; i++) {
            candidate[i] = new ArrayList<>();
        }
        comb(0, n / 2, 0, 0, c);
        comb(n / 2, n, 0, 1, c);
        Collections.sort(candidate[1]);

        int cnt = 0;
        for (int i = 0; i < candidate[0].size(); i++) {
            cnt += binarySearch(c - candidate[0].get(i));
        }
        System.out.println(cnt);
    }

    public static void comb(int s, int e, int sum, int idx, int c) {
        if (sum > c) return;
        if (s == e) {
            candidate[idx].add(sum);
            return;
        }
        comb(s + 1, e, sum, idx, c);
        comb(s + 1, e, sum + arr[s], idx, c);
    }

    public static int binarySearch(int n) {
        int low = 0, high = candidate[1].size() - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (candidate[1].get(mid) <= n) low = mid + 1;
            else high = mid - 1;
        }
        return high + 1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}