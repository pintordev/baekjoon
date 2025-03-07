import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        PriorityQueue<Station> stations = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            stations.add(new Station(read(), read()));
        }

        int l = read();
        int p = read();

        int stop = 0;
        PriorityQueue<Integer> fuels = new PriorityQueue<>((a, b) -> b - a);
        while (p < l) {
            while (!stations.isEmpty() && stations.peek().dist <= p) {
                fuels.add(stations.poll().fuel);
            }

            if (fuels.isEmpty()) {
                stop = -1;
                break;
            }

            p += fuels.poll();
            stop++;
        }
        System.out.println(stop);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Station implements Comparable<Station> {
    int dist;
    int fuel;

    public Station(int dist, int fuel) {
        this.dist = dist;
        this.fuel = fuel;
    }

    @Override
    public int compareTo(Station o) {
        return this.dist - o.dist;
    }
}