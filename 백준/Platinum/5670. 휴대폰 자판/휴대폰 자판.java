import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = read()) != -1) {
            sb.append(simulate(n)).append('\n');
        }
        System.out.println(sb);
    }

    public static String simulate(int n) throws IOException {
        String[] words = new String[n];
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert((words[i] = readString()));
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += trie.search(words[i]);
        }
        return String.format("%.2f", (double) cnt / n);
    }

    public static int read() throws IOException {
        int c, n = System.in.read();
        if (n == -1) return -1;
        n &= 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 13) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}

class Node {
    Map<Character, Node> child;
    boolean eof;

    public Node() {
        this.child = new HashMap<>();
        this.eof = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;

        for (int i = 0, len = word.length(); i < len; i++) {
            cur = cur.child.computeIfAbsent(word.charAt(i), f -> new Node());
        }
        cur.eof = true;
    }

    public int search(String word) {
        Node cur = root;

        int cnt = 0;
        for (int i = 0, len = word.length(); i < len; i++) {
            cur = cur.child.get(word.charAt(i));
            if (cur.eof || cur.child.size() > 1) cnt++;
        }
        return cnt;
    }
}