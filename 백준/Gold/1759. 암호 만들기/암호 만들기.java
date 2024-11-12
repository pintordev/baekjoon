import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int l = read();
        int c = read();

        char[] a = readChars(c);
        Arrays.sort(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 1 << c; i >= 0; i--) {
            if (Integer.bitCount(i) != l) continue;

            StringBuilder temp = new StringBuilder();
            int con = 0;
            int vow = 0;
            for (int j = c - 1; j >= 0; j--) {
                if ((i & 1 << j) == 0) continue;
                temp.append(a[c - j - 1]);
                if (a[c - j - 1] == 'a' || a[c - j - 1] == 'e' || a[c - j - 1] == 'i' || a[c - j - 1] == 'o' || a[c - j - 1] == 'u') vow++;
                else con++;
            }
            if (con > 1 && vow > 0) sb.append(temp).append('\n');
        }
        System.out.print(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0;
        while (len-- > 0) {
            c[idx++] = (char) System.in.read();
            System.in.read();
        }
        return c;
    }
}