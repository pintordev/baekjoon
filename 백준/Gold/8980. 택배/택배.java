import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int c = read();
        int m = read();

        Box[] boxes = new Box[m];
        for (int i = 0; i < m; i++) {
            boxes[i] = new Box(read(), read(), read());
        }
        Arrays.sort(boxes);

        int[] town = new int[n + 1];
        Arrays.fill(town, c);

        int max = 0;
        for (Box box : boxes) {
            int min = Integer.MAX_VALUE;
            for (int i = box.s; i < box.e; i++) {
                min = Math.min(min, town[i]);
            }

            if (min >= box.cnt) {
                for (int i = box.s; i < box.e; i++) {
                    town[i] -= box.cnt;
                }
                max += box.cnt;
            } else {
                for (int i = box.s; i < box.e; i++) {
                    town[i] -= min;
                }
                max += min;
            }
        }
        System.out.println(max);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Box implements Comparable<Box> {
    int s, e, cnt;

    public Box(int s, int e, int cnt) {
        this.s = s;
        this.e = e;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Box o) {
        if (this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }
}