import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), k = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) pq.add(read());
        while (--k > 0) pq.poll();
        System.out.println(pq.peek());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}