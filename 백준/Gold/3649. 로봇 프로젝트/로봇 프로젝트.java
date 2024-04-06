import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            int x = Integer.parseInt(s) * 10000000;

            int n = Integer.parseInt(br.readLine());
            int[] blocks = new int[n];
            for (int i = 0; i < n; i++) {
                blocks[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(blocks);

            int ldx = 0;
            int rdx = n - 1;
            int lb = 0;
            int rb = 0;
            boolean found = false;
            while (ldx < rdx) {
                lb = blocks[ldx];
                rb = blocks[rdx];

                if (lb + rb < x) {
                    ldx++;
                } else if (lb + rb > x) {
                    rdx--;
                } else {
                    found = true;
                    break;
                }
            }

            if (found) {
                sb.append("yes").append(' ').append(lb).append(' ').append(rb).append('\n');
            } else {
                sb.append("danger").append('\n');
            }
        }

        System.out.println(sb);
    }
}