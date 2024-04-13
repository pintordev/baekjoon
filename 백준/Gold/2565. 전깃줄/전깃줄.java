import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Wire[] wires = new Wire[n];
        for (int i = 0; i < n; i++) {
            wires[i] = new Wire(read(), read());
        }
        Arrays.sort(wires);

        int[] memo = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[i].b > wires[j].b) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }
        System.out.println(n - max);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Wire implements Comparable<Wire> {
    int a;
    int b;

    public Wire(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Wire o) {
        return this.a - o.a;
    }
}