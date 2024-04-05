import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] solutions = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            solutions[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(solutions);

        int ldx = 0;
        int rdx = solutions.length - 1;
        long minLS = solutions[ldx];
        long minRS = solutions[rdx];
        long min = Math.abs(minLS + minRS);
        while (ldx < rdx) {
            long ls = solutions[ldx];
            long rs = solutions[rdx];

            if (min > Math.abs(ls + rs)) {
                min = Math.abs(ls + rs);
                minLS = ls;
                minRS = rs;
            }

            if (ls + rs < 0) {
                ldx++;
            } else if (ls + rs > 0) {
                rdx--;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minLS).append(' ').append(minRS);
        System.out.println(sb);
    }
}