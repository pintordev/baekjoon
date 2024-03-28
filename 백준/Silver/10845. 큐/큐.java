import java.io.IOException;
import java.util.LinkedList;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        LinkedList<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String command = readString();
            if (command.equals("push")) queue.addLast(read());
            else if (command.equals("pop")) {
                if (!queue.isEmpty()) sb.append(queue.pollFirst()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command.equals("size")) sb.append(queue.size()).append('\n');
            else if (command.equals("empty")) sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            else if (command.equals("front")) {
                if (!queue.isEmpty()) sb.append(queue.peekFirst()).append('\n');
                else sb.append(-1).append('\n');
            }
            else if (command.equals("back")) {
                if (!queue.isEmpty()) sb.append(queue.peekLast()).append('\n');
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

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}