import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] solutions = new int[n];
        for (int i = 0; i < n; i++) {
            solutions[i] = read();
        }

        Arrays.sort(solutions);

        int ldx = 0;
        int rdx = solutions.length - 1;
        int minLS = solutions[ldx];
        int minRS = solutions[rdx];
        long min = Math.abs(minLS + minRS);
        while (ldx < rdx) {
            int ls = solutions[ldx];
            int rs = solutions[rdx];

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
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}