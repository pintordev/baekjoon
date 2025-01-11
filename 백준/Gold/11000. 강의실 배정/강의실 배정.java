import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Class> request = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            request.add(new Class(read(), read()));
        }

        PriorityQueue<Integer> done = new PriorityQueue<>();
        while (!request.isEmpty()) {
            Class c = request.poll();
            if (!done.isEmpty() && done.peek() <= c.start) done.poll();
            done.add(c.end);
        }
        System.out.println(done.size());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Class implements Comparable<Class> {
    int start;
    int end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class o) {
        if (this.start == o.start) return this.end - o.end;
        return this.start - o.start;
    }
}