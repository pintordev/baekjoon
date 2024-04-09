import java.io.IOException;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Stack<Integer> skyLine = new Stack<>();
        int cnt = 0;
        while (n-- > 0) {
            read();
            int h = read();
            while (!skyLine.isEmpty() && skyLine.peek() > h) {
                skyLine.pop();
                cnt++;
            }
            if (!skyLine.isEmpty() && skyLine.peek() == h) {
                continue;
            }
            if (h > 0) {
                skyLine.add(h);
            }
        }

        while (!skyLine.isEmpty()) {
            skyLine.pop();
            cnt++;
        }

        System.out.println(cnt);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}