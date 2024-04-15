import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] c1 = readChars();
        char[] c2 = readChars();

        int c1Len = c1.length;
        int c2Len = c2.length;
        int[][] memo = new int[c1Len + 1][c2Len + 1];
        for (int i = 1; i <= c1Len; i++) {
            for (int j = 1; j <= c2Len; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        System.out.println(memo[c1Len][c2Len]);
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[1000];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}