import java.util.*;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int n = target.length;
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, target[i - 1]);
        }

        for (int[] edge : edges) {
            nodes[edge[0]].add(nodes[edge[1]]);
        }

        int leafCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!nodes[i].isParent && nodes[i].max > 0) leafCnt++;
            nodes[i].sort();
        }

        List<Node> drops = new ArrayList<>();
        while (leafCnt > 0) {
            Node drop = nodes[1].drop();
            if (drop.cnt > drop.max) return new int[]{-1};
            if (!drop.made && drop.cnt >= drop.min) {
                drop.made = true;
                leafCnt--;
            }
            drops.add(drop);
        }

        int m = drops.size();
        int[] result = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            Node drop = drops.get(i);
            for (int j = 3; j >= 1; j--) {
                if (drop.max - j < drop.cnt - 1) continue;
                drop.max -= j;
                drop.cnt--;
                result[i] = j;
                break;
            }
        }
        return result;
    }
}

class Node implements Comparable<Node> {
    int idx;
    int cnt;
    int max;
    int min;
    boolean isParent;
    boolean made;
    List<Node> children;
    int size;

    public Node(int idx, int target) {
        this.idx = idx;
        this.cnt = 0;
        this.max = target;
        this.min = target / 3 + target % 3 / 2 + target % 3 % 2;
        this.children = new ArrayList<>();
    }

    public void add(Node child) {
        isParent = true;
        children.add(child);
    }

    public void sort() {
        size = children.size();
        Collections.sort(children);
    }

    public Node drop() {
        cnt++;
        if (isParent) return children.get((cnt - 1) % size).drop();
        return this;
    }

    @Override
    public int compareTo(Node o) {
        return this.idx - o.idx;
    }
}