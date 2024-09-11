import java.io.IOException;

public class Main {
    public static int[] pre;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        pre = new int[10001];

        int idx = 0;
        int num;
        while ((num = read()) != -1) pre[idx++] = num;

        postOrder(0, idx - 1);
        System.out.println(sb);
    }

    public static void postOrder(int s, int e) {
        if (s > e) return;

        int m = s + 1;
        while (m <= e && pre[m] < pre[s]) m++;

        postOrder(s + 1, m - 1);
        postOrder(m, e);
        sb.append(pre[s]).append('\n');
    }

    public static int read() throws IOException {
        int c, n = System.in.read();
        if (n == -1) return -1;
        n &= 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}