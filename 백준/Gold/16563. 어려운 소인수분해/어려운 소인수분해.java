import java.io.IOException;

public class Main {
    public static int maxK = 5_000_000;

    public static void main(String[] args) throws IOException {
        int n = read();

        int[] minP = new int[maxK + 1];
        for (int i = 2; i <= maxK; i++) {
            minP[i] = i;
        }

        for (int i = 2; i * i <= maxK; i++) {
            if (minP[i] != i) continue;
            for (int j = i * i; j <= maxK; j += i) {
                if (minP[j] == j) minP[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int k = read();
            while (k > 1) {
                sb.append(minP[k]).append(' ');
                k /= minP[k];
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}