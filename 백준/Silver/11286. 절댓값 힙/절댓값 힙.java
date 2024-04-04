import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) pq.add(x);
            else if (!pq.isEmpty()) System.out.println(pq.poll());
            else System.out.println("0");
        }
    }
}