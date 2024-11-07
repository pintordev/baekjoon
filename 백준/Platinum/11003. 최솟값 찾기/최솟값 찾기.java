import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int l = read();

        StringBuilder sb = new StringBuilder();
        Deque<Num> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            Num num = new Num(read(), i);
            while (!deque.isEmpty() && deque.peekLast().val > num.val) deque.pollLast();
            deque.addLast(num);
            if (deque.peekFirst().idx <= i - l) deque.pollFirst();
            sb.append(deque.peekFirst().val).append(' ');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}

class Num {
    int val;
    int idx;

    public Num(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}