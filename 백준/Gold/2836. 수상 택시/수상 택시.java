import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        PriorityQueue<Passenger> passengers = new PriorityQueue<>();
        while (n-- > 0) {
            int s = read();
            int e = read();
            if (s <= e) continue;
            passengers.add(new Passenger(s, e));
        }

        long dis = 0;
        int prev = 0;
        while (!passengers.isEmpty()) {
            Passenger p = passengers.poll();
            if (prev >= p.s) continue;
            if (prev >= p.e) dis += p.s - prev;
            else dis += p.s - p.e;
            prev = p.s;
        }
        System.out.println(m + (dis << 1));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Passenger implements Comparable<Passenger> {
    int s;
    int e;

    public Passenger(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Passenger o) {
        if (this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }
}