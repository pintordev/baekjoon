import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        List<Integer> limits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            limits.add(read());
        }

        int m = read();
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            weights.add(read());
        }

        limits.sort(Comparator.reverseOrder());
        weights.sort(Comparator.reverseOrder());

        if (limits.get(0) < weights.get(0)) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while (!weights.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < n;) {
                if (idx == weights.size()) break;
                if (limits.get(i) >= weights.get(idx)) {
                    weights.remove(idx);
                    i++;
                }
                else idx++;
            }
            cnt++;
        }
        System.out.println(cnt);


    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}