class Solution {
    public int solution(int n, int[][] computers) {

        boolean[] visited = new boolean[n];

        int network = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                network++;
                dfs(n, computers, visited, i);
            }
        }

        return network;
    }

    public void dfs(int n, int[][] computers, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (j != i && !visited[j] && computers[i][j] == 1) {
                dfs(n, computers, visited, j);
            }
        }
    }
}