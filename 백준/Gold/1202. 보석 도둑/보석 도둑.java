import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        PriorityQueue<Jewel> jwq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        while (n-- > 0) {
            jwq.add(new Jewel(read(), read()));
        }

        PriorityQueue<Integer> bwq = new PriorityQueue<>();
        while (k-- > 0) {
            bwq.add(read());
        }

        long sum = 0;
        PriorityQueue<Jewel> jpq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.price));
        while (!bwq.isEmpty()) {
            int bagWeight = bwq.poll();
            while (!jwq.isEmpty() && jwq.peek().weight <= bagWeight) {
                jpq.offer(jwq.poll());
            }
            if (!jpq.isEmpty()) {
                sum += jpq.poll().price;
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

class Jewel {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}