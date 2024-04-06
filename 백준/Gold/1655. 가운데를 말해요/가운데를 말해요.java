import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();
        int num = read();
        sb.append(num).append('\n');
        leftQ.add(num);
        for (int i = 1; i < n; i++) {
            num = read();
            if (leftQ.peek() < num) {
                rightQ.add(num);
            } else {
                leftQ.add(num);
            }
            while (leftQ.size() > rightQ.size() + 1) {
                rightQ.add(leftQ.poll());
            }
            while (rightQ.size() > leftQ.size()) {
                leftQ.add(rightQ.poll());
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