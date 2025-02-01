import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), k = read();

        byte[] number = readBytes(n);

        byte[] s = new byte[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            while (top > 0 && s[top - 1] < number[i] && k > 0) {
                top--;
                k--;
            }
            s[top++] = number[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top - k; i++) {
            sb.append((char) s[i]);
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static byte[] readBytes(int len) throws IOException {
        byte[] c = new byte[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (byte) ch;
        return Arrays.copyOf(c, idx);
    }
}