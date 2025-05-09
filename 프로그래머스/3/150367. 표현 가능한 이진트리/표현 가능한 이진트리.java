class Solution {
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            String s = extendBinaryString(numbers[i]);
            result[i] = dfs(s);
        }
        return result;
    }

    public String extendBinaryString(long number) {
        String s = Long.toBinaryString(number);
        int len = s.length();
        int n = 1;
        while (len > Math.pow(2, n) - 1) {
            n++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat((int) (Math.pow(2, n) - 1 - len))).append(s);
        return sb.toString();
    }

    public int dfs(String s) {
        int len = s.length();
        if (len == 1) return 1;
        if (s.charAt(len / 2) == '0') {
            for (char c : s.toCharArray()) {
                if (c == '1') return 0;
            }
            return 1;
        }
        return dfs(s.substring(0, len / 2)) & dfs(s.substring(len / 2 + 1));
    }
}