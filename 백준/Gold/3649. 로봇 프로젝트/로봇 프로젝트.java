import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        L:
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }

            int x = Integer.parseInt(s) * 10000000;

            int n = Integer.parseInt(br.readLine());
            int[] blocks = new int[n];
            for (int i = 0; i < n; i++) {
                blocks[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(blocks);

            int ldx = 0;
            int rdx = n - 1;
            while (ldx < rdx) {
                int sum = blocks[ldx] + blocks[rdx];

                if (sum < x) {
                    ldx++;
                } else if (sum > x) {
                    rdx--;
                } else {
                    sb.append("yes").append(' ')
                            .append(blocks[ldx]).append(' ')
                            .append(blocks[rdx]).append('\n');
                    continue L;
                }
            }
            sb.append("danger").append('\n');
        }

        System.out.println(sb);
    }
}