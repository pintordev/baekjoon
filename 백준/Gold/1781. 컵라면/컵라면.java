import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Ramen[] ramens = new Ramen[n];
        for (int i = 0; i < n; i++) {
            ramens[i] = new Ramen(read(), read());
        }
        Arrays.sort(ramens, new Comparator<Ramen>() {
            @Override
            public int compare(Ramen o1, Ramen o2) {
                if (o1.due < o2.due) return 1;
                else if (o1.due == o2.due) return 0;
                else return -1;
            }
        });

        PriorityQueue<Ramen> pq = new PriorityQueue<>();
        int cnt = 0;
        int sum = 0;
        for (int i = 200000; i >= 1; i--) {
            while (cnt < n && ramens[cnt].due == i) {
                pq.add(ramens[cnt++]);
            }
            if (!pq.isEmpty()) sum += pq.poll().cnt;
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

class Ramen implements Comparable<Ramen> {
    int due;
    int cnt;

    public Ramen(int due, int cnt) {
        this.due = due;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Ramen o) {
        if (this.cnt < o.cnt) return 1;
        else if (this.cnt == o.cnt) {
            if (this.due > o.due) return 1;
            else if (this.due == o.due) return 0;
        }
        return -1;
    }
}