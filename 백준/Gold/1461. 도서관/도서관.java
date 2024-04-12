import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        input = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            if (num < 0) minQ.add(num);
            else maxQ.add(num);
            max = Math.max(max, Math.abs(num));
        }

        int sum = 0;
        L: while (!minQ.isEmpty()) {
            sum += minQ.peek() * -2;
            for (int i = 0; i < m; i++) {
                if (minQ.isEmpty()) {
                    break L;
                }
                minQ.poll();
            }
        }
        R: while (!maxQ.isEmpty()) {
            sum += maxQ.peek() * 2;
            for (int i = 0; i < m; i++) {
                if (maxQ.isEmpty()) {
                    break R;
                }
                maxQ.poll();
            }
        }
        sum -= max;

        System.out.println(sum);
    }
}