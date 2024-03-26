class Solution {
    public int[] solution(long begin, long end) {

        int[] result = new int[(int) (end - begin + 1)];
        for (long i = begin; i <= end; i++) {
            result[(int) (i - begin)] = find(i);
        }

        return result;
    }

    public int find(long n) {

        if (n == 1) return 0;

        long r = 1;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                 if (n / i <= 10000000) return (int) (n / i);
                 r = i;
            }
        }

        return (int) r;
    }
}