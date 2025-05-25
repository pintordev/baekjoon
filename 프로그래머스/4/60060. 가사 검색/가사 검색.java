import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> front = new HashMap<>();
        Map<Integer, List<String>> back = new HashMap<>();
        for (String word : words) {
            int wLen = word.length();
            front.computeIfAbsent(wLen, k -> new ArrayList<>()).add(word);
            back.computeIfAbsent(wLen, k -> new ArrayList<>()).add(reverse(word));
        }

        for(int key : front.keySet()) {
            front.get(key).sort(String::compareTo);
            back.get(key).sort(String::compareTo);
        }

        int qLen = queries.length;
        int[] result = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            if (queries[i].charAt(0) != '?') result[i] = search(front, queries[i]);
            else result[i] = search(back, reverse(queries[i]));
        }
        return result;
    }

    public int search(Map<Integer, List<String>> list, String query) {
        int len = query.length();
        if (!list.containsKey(len)) return 0;

        String ls = query.replace('?', 'a');
        String us = query.replace('?', 'z');

        return binarySearch(list.get(len), us) - binarySearch(list.get(len), ls);
    }

    public int binarySearch(List<String> words, String str) {
        int low = -1;
        int high = words.size();
        while (low + 1 < high) {
            int mid = (low + high) >> 1;
            if (words.get(mid).compareTo(str) <= 0) low = mid;
            else high = mid;
        }
        return high;
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}