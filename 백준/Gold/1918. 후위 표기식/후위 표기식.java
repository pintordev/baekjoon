import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] exp = readChars(100);

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char e : exp) {
            switch (e) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(e)) {
                        sb.append(stack.pop());
                    }
                    stack.push(e);
                    break;
                case '(':
                    stack.push(e);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(e);
                    break;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    public static int priority(char op) {
        switch (op) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}