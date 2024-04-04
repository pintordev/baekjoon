import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) return o1 - o2;
            return abs1 - abs2;
        });

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else if (!pq.isEmpty()) {
                sb.append(pq.poll()).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}