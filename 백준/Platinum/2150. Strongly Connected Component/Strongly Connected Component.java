import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {
    public static List<Integer>[] graph;
    public static List<SCC> sccs;
    public static boolean[] visited;
    public static int[] ids;
    public static int id;
    public static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        int v = read();
        int e = read();

        graph = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            graph[read()].add(read());
        }

        sccs = new ArrayList<>();
        visited = new boolean[v + 1];
        ids = new int[v + 1];
        id = 0;
        stack = new Stack<>();
        for (int i = 1; i <= v; i++) {
            if (ids[i] == 0) dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sccs.size()).append('\n');
        sccs.sort(Comparator.comparingInt(scc -> scc.members.get(0)));
        for (SCC scc : sccs) {
            for (int member : scc.members) sb.append(member).append(' ');
            sb.append(-1).append('\n');
        }
        System.out.print(sb);
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
                if (j == i) break;
            }
            scc.members.sort(Comparator.comparing(Integer::intValue));
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