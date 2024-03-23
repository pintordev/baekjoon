import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n > 0) {
            pq.add(n % 10);
            n /= 10;
        }

        int num = 0, f = 1;
        while (!pq.isEmpty()) {
            num += pq.poll() * f;
            f *= 10;
        }
        System.out.println(num);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}