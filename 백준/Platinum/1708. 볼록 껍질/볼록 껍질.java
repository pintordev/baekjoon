import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(read(), read());
        }

        ConvexHull convexHull = new ConvexHull(points);
        convexHull.grahamScan();
        System.out.println(convexHull.size());
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

    public void grahamScan() {
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

    public int size() {
        Stack<Point> stack = new Stack<>();
        stack.push(root);

        for (Point point : points) {
            while (stack.size() > 1 && ccw(stack.get(stack.size() - 2), stack.peek(), point) <= 0) {
                stack.pop();
            }
            stack.push(point);
        }

        return stack.size();
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