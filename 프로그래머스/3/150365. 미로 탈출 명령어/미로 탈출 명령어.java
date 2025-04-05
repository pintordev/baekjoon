class Solution {
    public static String result;
    public static int n;
    public static int m;
    public static int r;
    public static int c;
    public static int k;
    public static char[] dir = {'d', 'l', 'r', 'u'};
    public static int[] dx = {1, 0, 0, -1};
    public static int[] dy = {0, -1, 1, 0};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        result = "impossible";
        int dis = distance(x, y, r, c);
        if (dis > k || (k - dis) % 2 == 1) return result;

        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;

        dfs(x, y, new StringBuilder());
        return result;
    }

    public void dfs(int x, int y, StringBuilder sb) {
        if (!result.equals("impossible")) return;
        if (sb.length() == k) {
            if (x == r && y == c) result = sb.toString();
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if (distance(nx, ny, r, c) > k - sb.length()) continue;

            sb.append(dir[i]);
            dfs(nx, ny, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int distance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}