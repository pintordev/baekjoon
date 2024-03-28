import java.io.IOException;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        LinkedList<Integer> deque = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String command = readString();
            if (command.equals("push_front")) deque.addFirst(read());
            else if (command.equals("push_back")) deque.addLast(read());
            else if (command.equals("pop_front")) {
                if (!deque.isEmpty()) sb.append(deque.pollFirst()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command.equals("pop_back")) {
                if (!deque.isEmpty()) sb.append(deque.pollLast()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command.equals("size")) sb.append(deque.size()).append('\n');
            else if (command.equals("empty")) sb.append(deque.isEmpty() ? 1 : 0).append('\n');
            else if (command.equals("front")) {
                if (!deque.isEmpty()) sb.append(deque.peekFirst()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command.equals("back")) {
                if (!deque.isEmpty()) sb.append(deque.peekLast()).append('\n');
                else sb.append(-1).append('\n');
            }
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

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}