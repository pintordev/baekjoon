import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        Candidate[] candidates = new Candidate[101];
        List<Candidate> attaches = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int id = read();
            if (candidates[id] == null) {
                candidates[id] = new Candidate(id, 0, 0);
            }

            if (candidates[id].isAttached) {
                candidates[id].recommend++;
            } else {
                if (attaches.size() == n) {
                    Collections.sort(attaches);
                    Candidate c = attaches.remove(0);
                    candidates[c.id].recommend = 0;
                    candidates[c.id].isAttached = false;
                }
                attaches.add(candidates[id]);
                candidates[id].recommend++;
                candidates[id].time = i;
                candidates[id].isAttached = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 101; i++) {
            if (candidates[i] != null && candidates[i].isAttached) {
                sb.append(candidates[i].id).append(' ');
            }
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Candidate implements Comparable<Candidate> {
    int id;
    int recommend;
    int time;
    boolean isAttached;

    public Candidate(int id, int recommend, int time) {
        this.id = id;
        this.recommend = recommend;
        this.time = time;
    }

    @Override
    public int compareTo(Candidate o) {
        if (this.recommend == o.recommend) {
            return this.time - o.time;
        } else {
            return this.recommend - o.recommend;
        }
    }
}