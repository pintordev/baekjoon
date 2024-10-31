import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] s = readChars();

        int len = s.length - 1;

        boolean[][] isP = new boolean[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            isP[i][i] = true;
        }

        int[] memo = new int[len + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= len; i++) {
            memo[i] = memo[i - 1] + 1;
            for (int j = 1; j < i; j++) {
                if (s[i] == s[j] && (i - j == 1 || isP[j + 1][i - 1])) {
                    isP[j][i] = true;
                    memo[i] = Math.min(memo[i], memo[j - 1] + 1);
                }
            }
        }
        System.out.println(memo[len]);
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[2501];
        int idx = 1, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}