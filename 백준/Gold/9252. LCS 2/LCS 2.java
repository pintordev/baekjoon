import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] a = readChars();
        char[] b = readChars();
        int aLen = a.length;
        int bLen = b.length;

        int[][] memo = new int[aLen + 1][bLen + 1];
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a[i - 1] == b[j - 1]) memo[i][j] = memo[i - 1][j - 1] + 1;
                else memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(memo[aLen][bLen]).append('\n');

        Stack<Character> stack = new Stack<>();
        int i = aLen, j = bLen;
        while (i > 0 && j > 0) {
            if (memo[i][j] == memo[i - 1][j]) i--;
            else if (memo[i][j] == memo[i][j - 1]) j--;
            else {
                stack.push(a[i - 1]);
                i--; j--;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[1000];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}