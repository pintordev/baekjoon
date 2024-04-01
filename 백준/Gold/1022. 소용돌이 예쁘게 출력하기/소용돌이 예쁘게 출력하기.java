import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int r1 = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int r2 = Integer.parseInt(input[2]);
        int c2 = Integer.parseInt(input[3]);

        int[][] tornado = new int[r2 - r1 + 1][c2 - c1 + 1];
        int max = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int order = Math.max(Math.abs(i), Math.abs(j));
                int end = (2 * order + 1) * (2 * order + 1);
                int idx = i - r1, jdx = j - c1;
                if (i == order) tornado[idx][jdx] = end + j - order;
                else if (j == -1 * order) tornado[idx][jdx] = end - 2 * order + i - order;
                else if (i == -1 * order) tornado[idx][jdx] = end - 4 * order - (j + order);
                else if (j == order) tornado[idx][jdx] = end - 6 * order - (i + order);
                max = Math.max(max, tornado[idx][jdx]);
            }
        }

        int maxLen = String.valueOf(max).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tornado.length; i++) {
            for (int j = 0; j < tornado[0].length; j++) {
                String num = String.valueOf(tornado[i][j]);
                sb.append(" ".repeat(maxLen - num.length()))
                        .append(num).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}