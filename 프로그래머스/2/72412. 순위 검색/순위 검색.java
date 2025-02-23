import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {

        Map<String, List<Integer>> map = new HashMap<>();
        for (String s : info) {
            String[] bits = s.split(" ");
            add(map, bits, "", 0);
        }

        for (String key : map.keySet()) map.get(key).sort(Comparator.reverseOrder());

        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] bits = query[i].split(" and | ");
            List<Integer> list = map.getOrDefault(bits[0] + bits[1] + bits[2] + bits[3], new ArrayList<>());
            int limit = Integer.parseInt(bits[4]);
            result[i] = bs(list, limit);
        }

        return result;
    }

    public void add(Map<String, List<Integer>> map, String[] bits, String key, int count) {

        if (count == 4) {
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(Integer.parseInt(bits[4]));
            map.put(key, list);
            return;
        }

        add(map, bits, key + "-", count + 1);
        add(map, bits, key + bits[count], count + 1);
    }
    
    public int bs(List<Integer> list, int limit) {

        int lb = 0, rb = list.size() - 1;
        while (lb <= rb) {
            int m = (lb + rb) / 2;
            if (list.get(m) < limit) rb = m - 1;
            else lb = m + 1;
        }
        return lb;
    }
}