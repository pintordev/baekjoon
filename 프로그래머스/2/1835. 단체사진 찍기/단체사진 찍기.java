import java.util.*;

class Solution {
    public int solution(int n, String[] data) {
        char[] kf = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        return dfs(data, new HashMap<>(), kf, 0);
    }

    public int dfs(String[] data, Map<Character, Integer> map, char[] kf, int count) {

        if (map.size() == kf.length && isAllSTF(map, data)) return count + 1;

        for (int i = 0; i < kf.length; i++) {
            if (!map.containsKey(kf[i])) {
                map.put(kf[i], map.size());
                count = dfs(data, map, kf, count);
                map.remove(kf[i]);
            }
        }

        return count;
    }

    public boolean isAllSTF(Map<Character, Integer> arrange, String[] data) {
        for (String d : data) if(!isSTF(arrange, d)) return false;
        return true;
    }

    public boolean isSTF(Map<Character, Integer> arrange, String d) {

        int i = arrange.get(d.charAt(0));
        int j = arrange.get(d.charAt(2));
        char op = d.charAt(3);
        int m = d.charAt(4) - '0';

        if (op == '=') return Math.abs(j - i) == m + 1;
        else if (op == '>') return Math.abs(j - i) > m + 1;
        else return Math.abs(j - i) <= m;
    }
}