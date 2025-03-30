class Solution {
    public static int n;
    public static int m;
    public static int[][] key;
    public static int[][] map;
    public static int hole = 0;

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length + (n - 1) * 2;
        this.key = key;
        map = new int[m][m];
        for (int i = n - 1; i < m - n + 1; i++) {
            for (int j = n - 1; j < m - n + 1; j++) {
                map[i][j] = lock[i - n + 1][j - n + 1];
                if (map[i][j] == 0) hole++;
            }
        }

        if (isMatched()) return true;
        for (int i = 1; i < 4; i++) {
            rotate();
            if (isMatched()) return true;
        }
        return false;
    }

    public boolean isMatched() {
        for (int i = 0; i < m - n + 1; i++) {
            for (int j = 0; j < m - n + 1; j++) {
                if (canUnlock(i, j)) return true;
            }
        }
        return false;
    }

    public boolean canUnlock(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (r + i < n - 1 || r + i >= m - n + 1 || c + j < n - 1 || c + j >= m - n + 1) continue;
                if (map[r + i][c + j] == 1 && key[i][j] == 1) return false;
                if (map[r + i][c + j] == 0 && key[i][j] == 0) return false;
                if (map[r + i][c + j] == 0 && key[i][j] == 1) cnt++;
            }
        }
        return cnt == hole;
    }

    public void rotate() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = key[n - j - 1][i];
            }
        }
        key = temp;
    }
}