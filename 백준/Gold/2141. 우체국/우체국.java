import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Town> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long x = read();
            long a = read();
            pq.add(new Town(x, a));
            sum += a;
        }

        long mid = (sum + 1) >> 1;
        long left = 0;
        while (!pq.isEmpty()) {
            Town cur = pq.poll();
            left += cur.a;
            
            if (left < mid) continue;
            
            left = cur.x;
            break;
        }
        System.out.println(left);
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

class Town implements Comparable<Town> {
    long x;
    long a;

    public Town(long x, long a) {
        this.x = x;
        this.a = a;
    }

    @Override
    public int compareTo(Town o) {
        return (int) (this.x - o.x);
    }
}