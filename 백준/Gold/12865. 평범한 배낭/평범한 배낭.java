import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        Bag[] bags = new Bag[n + 1];
        for (int i = 1; i <= n; i++) {
            bags[i] = new Bag(read(), read());
        }

        int[] memo = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= bags[i].w; j--) {
                memo[j] = Math.max(memo[j], memo[j - bags[i].w] + bags[i].v);
            }
        }
        System.out.println(memo[k]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Bag {
    int w;
    int v;

    public Bag(int w, int v) {
        this.w = w;
        this.v = v;
    }
}