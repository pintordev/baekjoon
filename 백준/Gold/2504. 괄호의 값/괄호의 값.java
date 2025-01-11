import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] chars = readChars(30);

        Stack<Character> stack = new Stack<>();
        int sum = 0, mul = 1;
        for (int i = 0, len = chars.length; i < len; i++) {
            char c = chars[i];
            switch (c) {
                case '(':
                    stack.push(c);
                    mul *= 2;
                    break;
                case '[':
                    stack.push(c);
                    mul *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    if (chars[i - 1] == '(') sum += mul;
                    mul /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    }
                    stack.pop();
                    if (chars[i - 1] == '[') sum += mul;
                    mul /= 3;
                    break;
            }
        }
        System.out.println(stack.isEmpty() ? sum : 0);
    }

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}