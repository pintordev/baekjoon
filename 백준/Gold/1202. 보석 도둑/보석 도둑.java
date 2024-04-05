import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        PriorityQueue<Jewel> jwq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        while (n-- > 0) {
            input = br.readLine().split(" ");
            jwq.add(new Jewel(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        PriorityQueue<Integer> bwq = new PriorityQueue<>();
        while (k-- > 0) {
            bwq.add(Integer.parseInt(br.readLine()));
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
}

class Jewel {
    int weight;
    int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}