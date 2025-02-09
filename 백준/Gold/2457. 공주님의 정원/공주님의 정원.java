import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int[] days;

    public static void main(String[] args) throws IOException {
        init();

        int n = read();
        Flower[] flowers = new Flower[n];
        for (int i = 0; i < n; i++) {
            int s = dateToDays(read(), read());
            int e = dateToDays(read(), read());
            flowers[i] = new Flower(s, e);
        }
        Arrays.sort(flowers);

        int sd = dateToDays(3, 1);
        int ed = dateToDays(12, 1);
        int cd = 0, cnt = 0, idx = 0;
        while (cd < ed) {
            boolean found = false;
            for (int i = idx; i < n; i++) {
                if (flowers[i].s > sd) break;
                if (flowers[i].e <= cd) continue;
                cd = flowers[i].e;
                idx = i + 1;
                found = true;
            }

            if (found) {
                sd = cd;
                cnt++;
            }
            else break;
        }

        if (cd < ed) System.out.println(0);
        else System.out.println(cnt);
    }

    public static void init() {
        int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        days = new int[12];
        days[1] = d[0];
        for (int i = 2; i < 12; i++) {
            days[i] += days[i - 1] + d[i - 1];
        }
    }

    public static int dateToDays(int month, int day) {
        return days[month - 1] + day;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Flower implements Comparable<Flower> {
    int s;
    int e;

    public Flower(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.s == o.s) return this.e - o.e;
        return this.s - o.s;
    }
}