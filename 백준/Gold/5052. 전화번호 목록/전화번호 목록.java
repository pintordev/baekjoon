import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            if (solve()) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }

    public static boolean solve() throws IOException {
        TrieNode root = new TrieNode();

        int n = read();
        while (n-- > 0) {
            if (root.insert(readString())) continue;
            while (n-- > 0) readString();
            return false;
        }
        return true;
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

class TrieNode {
    TrieNode[] children;
    boolean eof;

    public TrieNode() {
        children = new TrieNode[10];
    }

    public boolean insert(String s) {
        TrieNode node = this;

        for (char c : s.toCharArray()) {
            int idx = c - '0';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            if (node.eof) return false;
            node = node.children[idx];
        }

        node.eof = true;
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }
}