import java.io.IOException;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int turn = 0;
        for (int i = 1; i <= m; i++) {
            int a = read();
            int b = read();

            if (find(a) == find(b)) {
                turn = i;
                break;
            }
            union(a, b);
        }
        System.out.println(turn);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}