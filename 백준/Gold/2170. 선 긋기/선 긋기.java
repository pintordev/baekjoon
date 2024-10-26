import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(read(), read());
        }
        Arrays.sort(lines);

        int len = lines[0].y - lines[0].x;
        int prev = lines[0].y;
        for (Line line : lines) {
            if (prev >= line.y) continue;
            if (prev >= line.x) len += line.y - prev;
            else len += line.y - line.x;
            prev = line.y;
        }
        System.out.println(len);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}

class Line implements Comparable<Line> {
    int x;
    int y;

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Line o) {
        if (this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}