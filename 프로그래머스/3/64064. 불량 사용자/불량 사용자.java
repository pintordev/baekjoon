import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {

        int[][] can = new int[banned_id.length][user_id.length];

        for (int i = 0; i < banned_id.length; i++) {
            int len = 0;
            for (int j = 0; j < user_id.length; j++) {
                if (isCan(banned_id[i], user_id[j])) can[i][len++] = j;
            }
            can[i] = Arrays.copyOf(can[i], len);
        }

        Set<String> set = new HashSet<>();
        dfs(can, new boolean[user_id.length], set, new int[banned_id.length], 0);
        return set.size();
    }

    public boolean isCan(String b, String u) {

        if (b.length() != u.length()) return false;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '*') continue;
            if (b.charAt(i) != u.charAt(i)) return false;
        }
        return true;
    }

    public void dfs(int[][] can, boolean[] visited, Set<String> set, int[] ban, int s) {

        if (s == can.length) {
            int[] _ban = Arrays.copyOf(ban, s);
            Arrays.sort(_ban);
            set.add(Arrays.toString(_ban));
            return;
        }

        for (int i = 0; i < can[s].length; i++) {
            if (!visited[can[s][i]]) {
                visited[can[s][i]] = true;
                ban[s] = can[s][i];
                dfs(can, visited, set, ban, s + 1);
                visited[can[s][i]] = false;
            }
        }
    }
}