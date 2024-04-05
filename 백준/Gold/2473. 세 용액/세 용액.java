import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] solutions = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(input[i]);
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
}