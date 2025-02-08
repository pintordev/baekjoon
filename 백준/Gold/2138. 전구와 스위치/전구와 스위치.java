import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int n;

    public static void main(String[] args) throws IOException {
        n = read();

        boolean[] a = readBooleans(n);
        boolean[] b = readBooleans(n);

        boolean[] c = Arrays.copyOf(a, n);
        c[0] = !c[0];
        c[1] = !c[1];

        int resA = solve(a, b);
        int resB = solve(c, b);
        if (resB != -1) resB++;

        if (resA == -1) System.out.println(resB);
        else if (resB == -1) System.out.println(resA);
        else System.out.println(Math.min(resA, resB));
    }

    public static int solve(boolean[] a, boolean[] b) {
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == b[i]) continue;
            cnt++;
            a[i] = !a[i];
            a[i + 1] = !a[i + 1];
            if (i != n - 2) a[i + 2] = !a[i + 2];
        }
        if (a[n - 1] != b[n - 1]) return -1;
        return cnt;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static boolean[] readBooleans(int len) throws IOException {
        boolean[] b = new boolean[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) b[idx++] = ch == 49;
        return b;
    }
}