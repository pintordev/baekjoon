import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double avg = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            pq.add(score);
            avg += score;
        }

        System.out.println(avg / pq.peek() * 100 / n);
    }
}