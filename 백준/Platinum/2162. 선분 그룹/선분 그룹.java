import java.io.IOException;

public class Main {
    public static Line[] lines;
    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) throws IOException {
        int n = read();

        lines = new Line[n];
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new Line(read(), read(), read(), read());
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isCrossed(lines[i], lines[j])) union(i, j);
            }
        }

        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
                max = Math.max(max, rank[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n').append(max);
        System.out.println(sb);
    }

    public static boolean isCrossed(Line a, Line b) {
        int j1 = ccw(a.p1, a.p2, b.p1) * ccw(a.p1, a.p2, b.p2);
        int j2 = ccw(b.p1, b.p2, a.p1) * ccw(b.p1, b.p2, a.p2);

        if (j1 == 0 && j2 == 0) {
            if (Math.min(a.p1.x, a.p2.x) <= Math.max(b.p1.x, b.p2.x) &&
                    Math.min(b.p1.x, b.p2.x) <= Math.max(a.p1.x, a.p2.x) &&
                    Math.min(a.p1.y, a.p2.y) <= Math.max(b.p1.y, b.p2.y) &&
                    Math.min(b.p1.y, b.p2.y) <= Math.max(a.p1.y, a.p2.y)) return true;
            else return false;
        } else if (j1 <= 0 && j2 <= 0) return true;
        else return false;
    }

    public static int ccw(Point p1, Point p2, Point p3) {
        int factor = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.y * p2.x - p2.y * p3.x - p3.y * p1.x;
        return Integer.compare(factor, 0);
    }

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
            rank[a] += rank[b];
        } else if (a > b) {
            parent[a] = b;
            rank[b] += rank[a];
        }
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
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    Point p1;
    Point p2;

    public Line(int x1, int y1, int x2, int y2) {
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }
}