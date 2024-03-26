import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        boolean[] isStack = new boolean[n];
        for (int i = 0; i < n; i++) isStack[i] = read() == 1 ? true : false;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!isStack[i]) stack.push(read());
            else read();
        }

        int m = read();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && m-- > 0) {
            sb.append(stack.pop()).append(' ');
        }
        while (m-- > 0) {
            sb.append(read()).append(' ');
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
}