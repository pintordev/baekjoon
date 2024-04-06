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
        int h = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while (n-- > 0) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (cnt < t && pq.peek() >= h) {
            int x = pq.poll();
            if (x > 1) {
                pq.add(x / 2);
            } else {
                pq.add(x);
            }
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        if (cnt == t && pq.peek() >= h) {
            sb.append("NO").append('\n').append(pq.peek());
        } else {
            sb.append("YES").append('\n').append(cnt);
        }
        System.out.println(sb);
    }
}