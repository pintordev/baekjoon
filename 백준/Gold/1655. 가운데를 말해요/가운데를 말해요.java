import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();
        while (n-- > 0) {
            if (leftQ.size() == rightQ.size()) {
                leftQ.add(read());
            } else {
                rightQ.add(read());
            }

            while (!rightQ.isEmpty() && leftQ.peek() > rightQ.peek()) {
                int left = leftQ.poll();
                int right = rightQ.poll();
                leftQ.add(right);
                rightQ.add(left);
            }

            sb.append(leftQ.peek()).append('\n');
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