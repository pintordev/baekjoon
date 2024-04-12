import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        String[] input;
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            maxDay = Math.max(maxDay, d);
            pq.add(new Lecture(p, d));
        }

        boolean[] visited = new boolean[maxDay + 1];
        int sum = 0;
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
            for (int i = lecture.d; i >= 1; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    sum += lecture.p;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}

class Lecture implements Comparable<Lecture> {
    int p;
    int d;

    public Lecture(int p, int d) {
        this.p = p;
        this.d = d;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.p == o.p) {
            return this.d - o.d;
        }
        return o.p - this.p;
    }
}