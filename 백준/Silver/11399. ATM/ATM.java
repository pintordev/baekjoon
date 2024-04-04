import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int[] p = new int[n];
        int[] pp = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = read();
        }
        Arrays.sort(p);

        int sum = p[0];
        pp[0] = p[0];
        for (int i = 1; i < n; i++) {
            pp[i] = pp[i - 1] + p[i];
            sum += pp[i];
        }
        System.out.println(sum);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}