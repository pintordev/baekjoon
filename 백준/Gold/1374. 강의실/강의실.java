import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Lecture[] lectures = new Lecture[n];
        for (int i = 0; i < n; i++) {
            lectures[i] = new Lecture(read(), read(), read());
        }
        Arrays.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lecture.s) pq.poll();
            pq.add(lecture.e);
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

class Lecture implements Comparable<Lecture> {
    int id;
    int s;
    int e;

    public Lecture(int id, int s, int e) {
        this.id = id;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.s == o.s) return this.e - o.e;
        return this.s - o.s;
    }
}