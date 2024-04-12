import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int p = read();
            int d = read();
            maxDay = Math.max(maxDay, d);
            pq.add(new Lecture(p, d));
        }

        boolean[] visited = new boolean[maxDay + 1];
        int sum = 0;
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            for (int i = lecture.d; i >= 1; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    sum += lecture.p;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Lecture implements Comparable<Lecture> {
    int p;
    int d;

    public Lecture(int p, int d) {
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.p - this.p;
    }
}