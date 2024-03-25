import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), k = read();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.add(i);

        StringBuilder sb = new StringBuilder().append('<');
        while (!queue.isEmpty()) {
            int count = 0;
            while (++count < k) queue.add(queue.poll());
            sb.append(queue.poll());
            if (queue.size() > 0) sb.append(',').append(' ');
        }
        sb.append('>');
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