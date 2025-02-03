import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), k = read();

        Appliance[] appliances = new Appliance[k + 1];
        for (int i = 1; i <= k; i++) {
            appliances[i] = new Appliance();
        }

        int[] order = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            int o = (order[i] = read());
            appliances[o].add(i);
        }

        int cnt = 0, p = 0;
        for (int i = 1; i <= k; i++) {
            int o = order[i];
            appliances[o].poll();
            if (appliances[o].on) continue;
            if (p < n) {
                appliances[o].on = true;
                p++;
                continue;
            }

            int toReplace = -1, last = -1;
            for (int j = 1; j <= k; j++) {
                if (!appliances[j].on) continue;
                if (appliances[j].isEmpty()) {
                    toReplace = j;
                    break;
                }
                if (appliances[j].peek() > last) {
                    last = appliances[j].peek();
                    toReplace = j;
                }
            }

            appliances[toReplace].on = false;
            appliances[o].on = true;
            cnt++;
        }
        System.out.println(cnt);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Appliance {
    boolean on;
    Queue<Integer> plan;

    public Appliance() {
        this.on = false;
        this.plan = new ArrayDeque<>();
    }

    public void add(int time) {
        plan.add(time);
    }

    public int peek() {
        return plan.peek();
    }

    public int poll() {
        return plan.poll();
    }

    public boolean isEmpty() {
        return plan.isEmpty();
    }
}