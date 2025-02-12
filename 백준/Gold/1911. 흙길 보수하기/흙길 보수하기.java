import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int l = read();

        Pool[] pools = new Pool[n];
        for (int i = 0; i < n; i++) {
            pools[i] = new Pool(read(), read());
        }
        Arrays.sort(pools);

        int cnt = 0;
        int ce = 0;
        for (Pool cur : pools) {
            if (cur.e < ce) continue;
            ce = Math.max(cur.s, ce);

            int diff = (cur.e - ce) % l;
            cnt += (cur.e - ce) / l;
            ce = cur.e;

            if (diff == 0) continue;
            cnt++;
            ce += l - diff;
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

class Pool implements Comparable<Pool> {
    int s;
    int e;

    public Pool(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Pool o) {
        if (this.s == o.s) return this.e - o.e;
        return this.s - o.s;
    }
}