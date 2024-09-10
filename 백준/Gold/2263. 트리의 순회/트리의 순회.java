import java.io.IOException;

public class Main {
    public static int[] in;
    public static int[] inIdx;
    public static int[] post;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = read();

        in = new int[n];
        inIdx = new int[n + 1];
        for (int i = 0; i < n; i++) {
            in[i] = read();
            inIdx[in[i]] = i;
        }

        post = new int[n];
        for (int i = 0; i < n; i++) {
            post[i] = read();
        }

        pre(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    public static void pre(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return;

        int root = post[pe];
        sb.append(root).append(' ');

        int ri = inIdx[root];
        pre(is, ri - 1, ps, ps + ri - is - 1);
        pre(ri + 1, ie, ps + ri - is, pe - 1);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}