import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Pillar[] pillars = new Pillar[n];
        int maxH = 0;
        int maxP = 0;
        for (int i = 0; i < n; i++) {
            pillars[i] = new Pillar(read(), read());
            if (maxH <= pillars[i].h) {
                maxH = pillars[i].h;
                maxP = pillars[i].p;
            }
        }

        Arrays.sort(pillars, Comparator.comparingInt(pillar -> pillar.p));

        int area = 0;
        int prevH = 0;
        for (int i = 0; i < n && pillars[i].p <= maxP; i++) {
            if (prevH < pillars[i].h) {
                area += (pillars[i].h - prevH) * (maxP - pillars[i].p + 1);
                prevH = pillars[i].h;
            }
        }

        prevH = 0;
        for (int i = n - 1; pillars[i].p > maxP; i--) {
            if (prevH < pillars[i].h) {
                area += (pillars[i].h - prevH) * (pillars[i].p - maxP);
                prevH = pillars[i].h;
            }
        }

        System.out.println(area);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Pillar {
    int p;
    int h;

    public Pillar(int p, int h) {
        this.p = p;
        this.h = h;
    }
}