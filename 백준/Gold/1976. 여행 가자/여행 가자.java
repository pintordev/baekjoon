import java.io.IOException;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int x = read();
                if (x == 1) union(i, j);
            }
        }

        int x = find(read());
        for (int i = 1; i < m; i++) {
            if (x != find(read())) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[a] = b;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}