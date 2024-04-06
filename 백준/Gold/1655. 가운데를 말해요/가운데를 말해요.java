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
        while (n-- > 0) {
            if (leftQ.size() == rightQ.size()) {
                leftQ.add(Integer.parseInt(br.readLine()));
            } else {
                rightQ.add(Integer.parseInt(br.readLine()));
            }

            while (!rightQ.isEmpty() && leftQ.peek() > rightQ.peek()) {
                int left = leftQ.poll();
                int right = rightQ.poll();
                leftQ.add(right);
                rightQ.add(left);
            }

            sb.append(leftQ.peek()).append('\n');
        }
        System.out.println(sb);
    }
}