import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] weighted = new int[26];
        while (n-- > 0) {
            char[] word = readChars(8);
            for (int i = word.length - 1, b = 1; i >= 0; i--, b *= 10) {
                weighted[word[i] - 'A'] += b;
            }
        }

        Arrays.sort(weighted);

        int sum = 0;
        for (int i = 25, weight = 9; i >= 0; i--, weight--) {
            sum += weighted[i] * weight;
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

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}