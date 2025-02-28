import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] children = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = read();
            children[j] = children[j - 1] + 1;
        }

        Arrays.sort(children);
        System.out.println(n - children[n]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}