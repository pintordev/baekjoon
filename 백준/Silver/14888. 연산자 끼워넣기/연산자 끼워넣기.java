import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Main {

    public static int[] num;
    public static int[] op;
    public static boolean[] used;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        num = new int[n];
        op = new int[n - 1];
        used = new boolean[n - 1];

        for (int i = 0; i < n; i++) num[i] = read();
        int jdx = 0;
        for (int i = 0; i < 4; i++) {
            int j = read();
            while (j-- > 0) op[jdx++] = i;
        }

        arrange(n - 1, 0, num[0]);

        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
    }

    public static void arrange(int limit, int depth, int sum) {

        if (depth == limit) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < limit; i++) {
            if (!used[i]) {
                used[i] = true;
                arrange(limit, depth + 1, calculate(sum, op[i], num[depth + 1]));
                used[i] = false;
            }
        }
    }

    public static int calculate(int sum, int op, int num) {
        if (op == 0) return sum + num;
        else if (op == 1) return sum - num;
        else if (op == 2) return sum * num;
        else return sum / num;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}