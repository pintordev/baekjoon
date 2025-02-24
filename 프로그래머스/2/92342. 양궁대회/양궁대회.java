import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        return shoot(info, new int[info.length], new int[]{-1}, n, new int[]{Integer.MIN_VALUE}, 0);
    }

    public int[] shoot(int[] info, int[] ryan, int[] result, int n, int[] max, int s) {

        if (n < 0) return result;

        if (s == info.length) {
            ryan[s - 1] += n;
            int diff = score(info, ryan);
            if (diff <= 0) return result;
            if (max[0] < diff || (max[0] == diff && last(result, ryan))) {
                max[0] = diff;
                result = Arrays.copyOf(ryan, ryan.length);
            }
            return result;
        }

        ryan[s] = info[s] + 1;
        result = shoot(info, ryan, result, n - ryan[s], max, s + 1);
        ryan[s] = 0;
        result = shoot(info, ryan, result, n, max, s + 1);

        return result;
    }

    public int score(int[] info, int[] ryan) {
        int si = 0, sr = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] >= ryan[i] && info[i] > 0) si += 10 - i;
            else if (ryan[i] > info[i]) sr += 10 - i;
        }
        return sr - si;
    }

    public boolean last(int[] result, int[] ryan) {
        for (int i = result.length - 1; i >= 0; i--) {
            if (ryan[i] > result[i]) return true;
            else if (result[i] > ryan[i]) return false;
        }
        return false;
    }
}