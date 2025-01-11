import java.io.IOException;
import java.util.Arrays;

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
            if (root.insert(readChars(10))) continue;
            while (n-- > 0) readChars(10);
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

    public static char[] readChars(int len) throws IOException {
        char[] c = new char[len];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}

class TrieNode {
    TrieNode[] children;
    boolean eof;

    public TrieNode() {
        children = new TrieNode[10];
    }

    public boolean insert(char[] numbers) {
        TrieNode node = this;

        for (char c : numbers) {
            int idx = c & 15;
            if (node.eof) return false;
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }

        node.eof = true;
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }
}