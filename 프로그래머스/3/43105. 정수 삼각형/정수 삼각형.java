class Solution {
    public int solution(int[][] triangle) {
        return max(triangle, triangle.length - 2);
    }

    public int max(int[][] triangle, int i) {
        for (int j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
        return i == 0 ? triangle[0][0] : max(triangle, i - 1);
    }
}