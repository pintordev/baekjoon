import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> leftQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();
        int median = Integer.parseInt(br.readLine());
        sb.append(median).append('\n');
        leftQ.add(median);
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (leftQ.peek() < num) {
                rightQ.add(num);
            } else {
                leftQ.add(num);
            }
            while (leftQ.size() > rightQ.size() + 1) {
                rightQ.add(leftQ.poll());
            }
            while (rightQ.size() > leftQ.size()) {
                leftQ.add(rightQ.poll());
            }
            sb.append(leftQ.peek()).append('\n');
        }
        System.out.println(sb);
    }
}