class Solution {
    public int solution(String begin, String target, String[] words) {
        return dfs(begin, target, words, new boolean[words.length], 0, 0);
    }

    public int dfs(String begin, String target, String[] words, boolean[] visited, int min, int convert) {

        if (begin.equals(target)) return min == 0 ? convert : Math.min(min, convert);

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && can(begin, words[i])) {
                visited[i] = true;
                min = dfs(words[i], target, words, visited, min, convert + 1);
                visited[i] = false;
            }
        }

        return min;
    }

    public boolean can(String begin, String word) {
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) count++;
        }
        return count == 1;
    }
}