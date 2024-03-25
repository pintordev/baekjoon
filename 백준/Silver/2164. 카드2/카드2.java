import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.add(i);

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.peek());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}