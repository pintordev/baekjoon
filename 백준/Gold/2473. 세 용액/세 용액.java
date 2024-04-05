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

        int minIS = solutions[0];
        int minJS = solutions[1];
        int minKS = solutions[n - 1];
        long min = Math.abs((long) minIS + minJS + minKS);
        L:
        for (int i = 0; i < n; i++) {
            int is = solutions[i];
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int js = solutions[j];
                int ks = solutions[k];

                long sum = (long) is + js + ks;
                long absSum = Math.abs(sum);
                if (min > absSum) {
                    min = absSum;
                    minIS = is;
                    minJS = js;
                    minKS = ks;
                }

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    break L;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minIS).append(' ').append(minJS).append(' ').append(minKS);
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