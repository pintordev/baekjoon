class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        
        int[] result = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int len = Integer.MAX_VALUE;
            for (int j = 0; j < 4; j++) {
                int sx = startX, sy = startY, bx = balls[i][0], by = balls[i][1];
                if (j == 0) {
                    sy = n - sy;
                    by = n - by;
                } else if (j == 1) {
                    sx = m - sx;
                    bx = m - bx;
                }

                if (j % 2 == 0 && bx == sx && by < sy) continue;
                if (j % 2 == 1 && by == sy && bx < sx) continue;

                if (j % 2 == 0) len = Math.min(len, (bx - sx) * (bx - sx) + (by + sy) * (by + sy));
                else if (j % 2 == 1) len = Math.min(len, (bx + sx) * (bx + sx) + (by - sy) * (by - sy));
            }

            result[i] = len;
        }

        return result;
    }
}