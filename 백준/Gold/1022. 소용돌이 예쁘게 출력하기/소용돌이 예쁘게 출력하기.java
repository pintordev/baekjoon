import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int r1, c1, r2, c2;
    public static int[][] tornado;
    public static int max = 0, n = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r1 = Integer.parseInt(input[0]);
        c1 = Integer.parseInt(input[1]);
        r2 = Integer.parseInt(input[2]);
        c2 = Integer.parseInt(input[3]);

        tornado = new int[r2 - r1 + 1][c2 - c1 + 1];

        int limit = Math.max(Math.max(Math.abs(r1), Math.abs(r2)), Math.max(Math.abs(c1), Math.abs(c2)));
        int r = 0, c = 0;
        write(r, c);
        for (int i = 1; i <= limit; i++) {
            write(r, ++c);
            for (int j = 0; j < 2 * i - 1; j++) write(--r, c);
            for (int j = 0; j < 2 * i; j++) write(r, --c);
            for (int j = 0; j < 2 * i; j++) write(++r, c);
            for (int j = 0; j < 2 * i; j++) write(r, ++c);
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

    public static void write(int r, int c) {
        ++n;
        if (r1 <= r && r <= r2 && c1 <= c && c <= c2) {
            tornado[r - r1][c - c1] = n;
            max = Math.max(max, n);
        }
    }
}