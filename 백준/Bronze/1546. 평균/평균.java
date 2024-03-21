import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) pq.add(Integer.parseInt(st.nextToken()));
        
        double avg = 0;
        int max = pq.peek();
        while (!pq.isEmpty()) avg += pq.poll();
        System.out.println(avg / max * 100 / n);
    }
}