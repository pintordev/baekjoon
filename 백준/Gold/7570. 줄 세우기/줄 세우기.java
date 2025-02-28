import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] children = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            children[read()] = i;
        }

        int max = 1, cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (children[i] > children[i - 1]) max = Math.max(max, ++cnt);
            else cnt = 1;
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