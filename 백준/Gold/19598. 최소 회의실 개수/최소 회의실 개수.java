import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(read(), read());
        }
        Arrays.sort(meetings);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(meetings[0].e);
        for (int i = 1; i < n; i++) {
            if (pq.peek() <= meetings[i].s) pq.poll();
            pq.add(meetings[i].e);
        }
        System.out.println(pq.size());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Meeting implements Comparable<Meeting> {
    int s;
    int e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.s == o.s) return this.e - o.e;
        return this.s - o.s;
    }
}