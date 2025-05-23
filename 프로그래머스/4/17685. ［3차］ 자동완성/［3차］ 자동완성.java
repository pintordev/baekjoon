import java.util.*;

class Solution {
    public int solution(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int cnt = 0;
        for (String word : words) {
            cnt += trie.search(word);
        }
        return cnt;
    }
}

class Node {
    Map<Character, Node> child;
    int childCnt;
    boolean eof;

    public Node() {
        this.child = new HashMap<>();
        this.childCnt = 0;
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
            cur.childCnt++;
            cur = cur.child.computeIfAbsent(word.charAt(i), f -> new Node());
        }
        cur.childCnt++;
        cur.eof = true;
    }

    public int search(String word) {
        Node cur = root;

        int len = word.length();
        int cnt = len;
        for (int i = 0; i < len; i++) {
            if (cur.childCnt == 1) return i;
            cur = cur.child.get(word.charAt(i));
        }
        return cnt;
    }
}