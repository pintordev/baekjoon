import java.util.*;

class Solution {
    public static int n;
    public static String[] result;
    public static String[] path;
    public static boolean[] visited;

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        result = new String[n + 1];
        path = new String[n + 1];
        visited = new boolean[n];

        path[0] = "ICN";
        dfs(tickets, "ICN", 0);

        return result;
    }

    public void dfs(String[][] tickets, String now, int depth) {
        if (depth == n) {
            if (result[0] == null || isBefore()) result = Arrays.copyOf(path, n + 1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                path[depth + 1] = tickets[i][1];
                dfs(tickets, tickets[i][1], depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean isBefore() {
        for (int i = 0; i < n; i++) {
            int factor = path[i].compareTo(result[i]);
            if (factor < 0) return true;
            else if (factor > 0) return false;
        }
        return false;
    }
}