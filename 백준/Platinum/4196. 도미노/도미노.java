import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static List<Integer>[] graph;
    public static List<SCC> sccs;
    public static boolean[] visited;
    public static int[] sccId;
    public static int[] ids;
    public static int id;
    public static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(simulate()).append('\n');
        }
        System.out.println(sb);
    }

    public static int simulate() throws IOException {
        int n = read();
        int m = read();

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            graph[read()].add(read());
        }

        sccs = new ArrayList<>();
        visited = new boolean[n + 1];
        sccId = new int[n + 1];
        ids = new int[n + 1];
        id = 0;
        stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (ids[i] == 0) dfs(i);
        }

        int len = sccs.size();
        boolean[] fallen = new boolean[len];
        for (int i = 1; i <= n; i++) {
            for (int j : graph[i]) {
                if (sccId[i] != sccId[j]) {
                    fallen[sccId[j]] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (!fallen[i]) cnt++;
        }
        return cnt;
    }

    public static int dfs(int i) {
        ids[i] = ++id;
        stack.push(i);

        int min = ids[i];
        for (int j : graph[i]) {
            if (ids[j] == 0) min = Math.min(min, dfs(j));
            else if (!visited[j]) min = Math.min(min, ids[j]);
        }

        if (min == ids[i]) {
            SCC scc = new SCC(sccs.size());
            while (true) {
                int j = stack.pop();
                scc.members.add(j);
                visited[j] = true;
                sccId[j] = scc.id;
                if (j == i) break;
            }
            sccs.add(scc);
        }
        return min;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class SCC {
    public int id;
    public List<Integer> members;

    public SCC(int id) {
        this.id = id;
        this.members = new ArrayList<>();
    }
}