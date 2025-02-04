import java.io.IOException;

public class Main {
    public static int[] gates;

    public static void main(String[] args) throws IOException {
        int g = read();
        gates = new int[g + 1];
        for (int i = 1; i <= g; i++) {
            gates[i] = i;
        }

        int p = read();
        int cnt = 0;
        for (int i = 0; i < p; i++) {
            int gi = read();
            int docking = find(gi);
            if (docking == 0) break;
            union(docking, docking - 1);
            cnt++;
        }
        System.out.println(cnt);
    }

    public static int find(int a) {
        if (gates[a] == a) return a;
        return gates[a] = find(gates[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        gates[a] = b;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}