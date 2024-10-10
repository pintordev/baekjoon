import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Node root = new Node("");
        for (int i = 0, n = read(); i < n; i++) {
            Node node = root;
            for (int j = 0, k = read(); j < k; j++) {
                String s = readString();
                node = node.children.computeIfAbsent(s, Node::new);
            }
        }

        addBuffer(root, 0);
        System.out.println(sb);
    }

    public static void addBuffer(Node cur, int depth) {
        for (var entry : cur.children.entrySet()) {
            sb.append("--".repeat(depth));
            sb.append(entry.getKey()).append('\n');
            addBuffer(entry.getValue(), depth + 1);
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
    public String name;
    public Map<String, Node> children;

    public Node(String name) {
        this.name = name;
        this.children = new TreeMap<>();
    }
}