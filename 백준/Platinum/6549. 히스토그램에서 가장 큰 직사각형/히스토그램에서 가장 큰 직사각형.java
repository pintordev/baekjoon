import java.io.IOException;
import java.util.Stack;

public class Main {
    public static int[] h;
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = read()) > 0) {
            h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = read();
            }
            sb.append(getMaxArea(n)).append('\n');
        }
        System.out.println(sb);
    }

    public static long getMaxArea(int n) {
        Stack<Integer> s = new Stack<>();
        long max = 0;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && h[s.peek()] > h[i]) {
                int height = h[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                max = Math.max(max, (long) height * width);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int height = h[s.pop()];
            int width = s.isEmpty() ? n : n - s.peek() - 1;
            max = Math.max(max, (long) height * width);
        }
        
        return max;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}