import java.io.IOException;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = read();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int idx = 0, i = 0;
        while (i++ < n) {
            stack.push(i);
            sb.append('+').append('\n');
            while (!stack.isEmpty() && num[idx] == stack.peek()) {
                stack.pop();
                sb.append('-').append('\n');
                idx++;
            }
        }
        if (idx == n) System.out.println(sb);
        else System.out.println("NO");
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}