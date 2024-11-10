import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int l = read();

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(read(), read());
        }

        ConvexHull convexHull = new ConvexHull(points);
        convexHull.scan();
        convexHull.make();
        convexHull.getWallLength(l);
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
            int ccw = ccw(root, a, b);
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

    public void getWallLength(int l) {
        int size = points.length;

        double length = 0;
        for (int i = 0; i < size; i++) {
            length += Math.sqrt(dist(points[i], points[(i + 1) % size]));
        }
        length += 2 * Math.PI * l;
        System.out.println(Math.round(length));
    }

    private int ccw(Point p1, Point p2, Point p3) {
        return p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
    }

    private int dist(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}