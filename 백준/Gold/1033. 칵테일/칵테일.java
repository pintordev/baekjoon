import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int n;
    public static List<Integer>[] adj;
    public static int[] cnt;
    public static int visit;

    public static void main(String[] args) throws IOException {
        n = read();

        adj = new List[n];
        cnt = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            cnt[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            int a = read(), b = read(), p = read(), q = read();

            int t1 = cnt[b] * p;
            int t2 = cnt[a] * q;
            int div = gcd(t1, t2);

            visit = 0;
            cocktail(a, t1 / div);
            cocktail(b, t2 / div);

            adj[a].add(b);
            adj[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(cnt[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void cocktail(int cur, int mul) {
        cnt[cur] *= mul;
        visit |= 1 << cur;

        for (int next : adj[cur]) {
            if ((visit & (1 << next)) != 0) continue;
            visit |= (1 << next);
            cocktail(next, mul);
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}