import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Assignment> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Assignment(read(), read()));
        }

        boolean[] done = new boolean[1001];
        int max = 0;
        while (!pq.isEmpty()) {
            Assignment cur = pq.poll();

            if (!done[cur.d]) {
                done[cur.d] = true;
                max += cur.w;
            } else {
                for (int i = cur.d - 1; i > 0; i--) {
                    if (!done[i]) {
                        done[i] = true;
                        max += cur.w;
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Assignment implements Comparable<Assignment> {
    int d;
    int w;

    public Assignment(int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Assignment o) {
        return o.w - this.w;
    }
}