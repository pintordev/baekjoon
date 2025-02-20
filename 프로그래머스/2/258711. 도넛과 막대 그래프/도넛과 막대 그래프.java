class Solution {
    public int[] solution(int[][] edges) {

        int[] in = new int[1000001];
        int[] out = new int[1000001];

        for (int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
        }

        int[] result = new int[4];
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0 && out[i] == 0) continue;
            if (in[i] == 0 && out[i] >= 2) result[0] = i;
            else if (out[i] == 0) result[2]++;
            else if (in[i] >= 2 && out[i] == 2) result[3]++;
        }

        result[1] = out[result[0]] - result[2] - result[3];

        return result;
    }
}