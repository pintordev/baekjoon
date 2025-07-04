class Solution {
    public static int mod = 1_000_000_007;
    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int len;

    public int solution(int[][] grid, int[] d, int k) {
        int n = grid.length;
        int m = grid[0].length;

        len = n * m;
        int dLen = d.length;
        long[][][] memo = new long[dLen + 1][len][len];
        for (int i = 0; i < len; i++) {
            memo[0][i][i] = 1;
        }
        for (int l = 1; l <= dLen; l++) {
            for (int i = 0; i < len; i++) {
                int r = i / m;
                int c = i % m;

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (grid[nr][nc] - grid[r][c] != d[l - 1]) continue;

                    for (int j = 0; j < len; j++) {
                        memo[l][j][nr * m + nc] += memo[l - 1][j][i];
                        memo[l][j][nr * m + nc] %= mod;
                    }
                }
            }
        }

        int eLen = log(2, k) + 1;
        long[][][] exp = new long[eLen][len][len];
        exp[0] = memo[dLen];
        for (int i = 1; i < eLen; i++) {
            exp[i] = mul(exp[i - 1], exp[i - 1]);
        }

        long[][] result = exp[log(2, k)];
        while ((k = res(2, k)) > 0) {
            result = mul(result, exp[log(2, k)]);
        }
        return sum(result);
    }

    public long[][] mul(long[][] a, long[][] b) {
        long[][] arr = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    arr[i][j] += a[i][k] * b[k][j];
                    arr[i][j] %= mod;
                }
            }
        }
        return arr;
    }

    public int sum(long[][] arr) {
        long sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum += arr[i][j];
                sum %= mod;
            }
        }
        return (int) sum;
    }

    public int log(int base, int exp) {
        return (int) (Math.log(exp) / Math.log(base));
    }

    public int res(int base, int exp) {
        return (int) (exp - Math.pow(base, log(base, exp)));
    }
}