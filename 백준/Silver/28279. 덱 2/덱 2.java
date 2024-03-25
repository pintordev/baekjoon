import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> deque = new LinkedList<>();
        while (n-- > 0) {
            int command = read();
            if (command == 1) deque.addFirst(read());
            else if (command == 2) deque.addLast(read());
            else if (command == 3) {
                if (deque.size() > 0) sb.append(deque.pollFirst()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command == 4) {
                if (deque.size() > 0) sb.append(deque.pollLast()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command == 5) sb.append(deque.size()).append('\n');
            else if (command == 6) sb.append(deque.isEmpty() ? 1: 0).append('\n');
            else if (command == 7) {
                if (deque.size() > 0) sb.append(deque.peekFirst()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command == 8) {
                if (deque.size() > 0) sb.append(deque.peekLast()).append('\n');
                else sb.append(-1).append('\n');
            }
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