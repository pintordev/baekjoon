import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, Node> map;

    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int f = read();

            map = new HashMap<>();
            int idx = 0;
            for (int i = 0; i < f; i++) {
                String a = readString();
                String b = readString();

                map.putIfAbsent(a, new Node());
                map.putIfAbsent(b, new Node());

                union(map.get(a), map.get(b));
                sb.append(find(map.get(a)).cnt).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static Node find(Node a) {
        if (a.parent == a) return a;
        return a.parent = find(a.parent);
    }

    public static void union(Node a, Node b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a.cnt > b.cnt) {
                b.parent = a;
                a.cnt += b.cnt;
            } else {
                a.parent = b;
                b.cnt += a.cnt;
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}

class Node {
    Node parent;
    int cnt;

    public Node() {
        parent = this;
        cnt = 1;
    }
}