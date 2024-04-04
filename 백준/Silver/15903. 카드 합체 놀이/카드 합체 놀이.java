import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(input[i]));
        }

        for (int i = 0; i < m; i++) {
            long sum = pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }

        long score = 0;
        while (!pq.isEmpty()) {
            score += pq.poll();
        }

        System.out.println(score);
    }
}