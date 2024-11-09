import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = read();

        while (t-- > 0) {
            simulate();
        }
        System.out.println(sb);
    }

    public static void simulate() throws IOException {
        int n = read();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(read(), read());
        }

        ConvexHull convexHull = new ConvexHull(points);
        convexHull.scan();
        convexHull.make();
        convexHull.getMaxDistance(sb);
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

class ConvexHull {
    Point root = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
    Point[] points;

    public ConvexHull(Point[] points) {
        this.points = points;
    }

    public void scan() {
        for (Point point : points) {
            if (root.y > point.y || (root.y == point.y && root.x > point.x)) root = point;
        }

        Arrays.sort(points, (a, b) -> {
            long ccw = ccw(root, a, b);
            if (ccw > 0) return -1;
            if (ccw < 0) return 1;
            if (dist(root, a) > dist(root, b)) return 1;
            return -1;
        });
    }

    public void make() {
        Stack<Point> stack = new Stack<>();
        stack.push(root);

        for (Point point : points) {
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.peek(), point) <= 0) {
                stack.pop();
            }
            stack.push(point);
        }

        points = new Point[stack.size()];
        int idx = stack.size();
        while (!stack.isEmpty()) {
            points[--idx] = stack.pop();
        }
    }

    public void getMaxDistance(StringBuilder sb) {
        long max = 0;
        long x1 = 0;
        long y1 = 0;
        long x2 = 0;
        long y2 = 0;
        int j = 1;
        int len = points.length;

        for (int i = 0; i < len; i++) {
            int ni = (i + 1) % len;
            while (true) {
                int nj = (j + 1) % len;
                long dx1 = points[ni].x - points[i].x;
                long dy1 = points[ni].y - points[i].y;
                long dx2 = points[nj].x - points[j].x;
                long dy2 = points[nj].y - points[j].y;

                long ccw = ccw(new Point(0, 0), new Point(dx1, dy1), new Point(dx2, dy2));
                if (ccw > 0) j = nj;
                else break;
            }

            long dist = dist(points[i], points[j]);
            if (dist <= max) continue;
            max = dist;
            x1 = points[i].x;
            y1 = points[i].y;
            x2 = points[j].x;
            y2 = points[j].y;
        }
        sb.append(x1).append(' ')
                .append(y1).append(' ')
                .append(x2).append(' ')
                .append(y2).append('\n');
    }

    private long ccw(Point p1, Point p2, Point p3) {
        return p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
    }

    private long dist(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
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