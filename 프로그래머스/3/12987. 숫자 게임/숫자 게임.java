import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        int score = 0, jdx = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (B[jdx] > A[i]) {
                score++;
                jdx--;
            }
        }

        return score;
    }
}