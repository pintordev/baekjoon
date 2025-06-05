class Solution {
    public static int result;

    public int solution(int n) {
        result = 0;
        dfs(n - 2, 2);
        return result;
    }

    public void dfs(int n, int p) {
        if (n < 1 || log(3, n) < p / 2) return;
        if (n == 1 && p == 0) {
            result++;
            return;
        }
        if (n % 3 == 0 && p >= 2) dfs(n / 3, p - 2);
        dfs(n - 1, p + 1);
    }

    public int log(int base, int exp) {
        return (int) (Math.log(exp) / Math.log(base));
    }
}