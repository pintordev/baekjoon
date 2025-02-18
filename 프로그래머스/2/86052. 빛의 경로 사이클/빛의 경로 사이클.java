import java.util.*;

class Solution {
    public int[] solution(String[] grid) {

        int m = grid.length, n = grid[0].length();
        boolean[][][] visited = new boolean[m][n][4];
        int[][] ds = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int count = 0;
                    int a = i, b = j, c = k;
                    while (!visited[a][b][c]) {
                        visited[a][b][c] = true;
                        count++;
                        a = (a + ds[c][0] + m) % m;
                        b = (b + ds[c][1] + n) % n;
                        c = rotate(c, grid[a].charAt(b));
                    }
                    if (count > 0) result.add(count);
                }
            }
        }
        
        return result.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public int rotate(int c, char node) {
        if (node == 'S') return c;
        else if (node == 'R') return (c + 1) % 4;
        else return (c - 1 + 4) % 4;
    }
}