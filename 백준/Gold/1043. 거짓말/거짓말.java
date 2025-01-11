import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), m = read();

        Guest[] guests = new Guest[n + 1];
        for (int i = 1; i <= n; i++) {
            guests[i] = new Guest();
        }

        int t = read();
        if (t == 0) {
            System.out.println(m);
            return;
        }
        while (t-- > 0) {
            guests[read()].known = true;
        }

        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            int k = read();
            parties[i] = new int[k];
            for (int j = 0; j < k; j++) {
                parties[i][j] = read();
            }

            int a = parties[i][0];
            for (int j = 1; j < k; j++) {
                union(guests[a], guests[parties[i][j]]);
            }
        }

        for (int[] party : parties) {
            for (int id : party) {
                if (!find(guests[id]).known) continue;
                m--;
                break;
            }
        }
        System.out.println(m);
    }

    public static void union(Guest a, Guest b) {
        a = find(a);
        b = find(b);
        if (a != b) b.parent = a;
        if (b.known) a.known = true;
    }

    public static Guest find(Guest a) {
        if (a.parent == a) return a;
        return a.parent = find(a.parent);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Guest {
    Guest parent;
    boolean known;

    public Guest() {
        parent = this;
    }
}