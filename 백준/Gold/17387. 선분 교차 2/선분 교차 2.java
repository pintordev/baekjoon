import java.io.IOException;

public class Main {
    public static Point[] points = new Point[4];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(read(), read());
        }
        System.out.println(isCross() ? 1 : 0);
    }

    public static boolean isCross() {
        int j1 = ccw(0, 1, 2) * ccw(0, 1, 3);
        int j2 = ccw(2, 3, 0) * ccw(2, 3, 1);

        if (j1 == 0 && j2 == 0) {
            if (Math.min(points[0].x, points[1].x) <= Math.max(points[2].x, points[3].x) &&
                    Math.min(points[2].x, points[3].x) <= Math.max(points[0].x, points[1].x) &&
                    Math.min(points[0].y, points[1].y) <= Math.max(points[2].y, points[3].y) &&
                    Math.min(points[2].y, points[3].y) <= Math.max(points[0].y, points[1].y)) {
                return true;
            }
        }
        return j1 < 0 && j2 < 0 || j1 < 0 && j2 == 0 || j1 == 0 && j2 < 0;
    }

    public static int ccw(int a, int b, int c) {
        long result = (points[a].x * points[b].y + points[b].x * points[c].y + points[c].x * points[a].y)
                - (points[a].y * points[b].x + points[b].y * points[c].x + points[c].y * points[a].x);
        return Long.compare(result, 0);
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

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}