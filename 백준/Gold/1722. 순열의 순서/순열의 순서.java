import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        boolean[] visited = new boolean[n + 1];
        if (read() == 1) {
            long k = readL();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) continue;
                    if (k - factorial[n - 1 - i] > 0) k -= factorial[n - 1 - i];
                    else {
                        visited[j] = true;
                        sb.append(j).append(' ');
                        break;
                    }
                }
            }
            System.out.println(sb);

        } else {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = read();
            }

            long k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < arr[i]; j++) {
                    if (!visited[j]) k += factorial[n - 1 - i];
                }
                visited[arr[i]] = true;
            }
            System.out.println(k + 1);
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static long readL() throws IOException {
        int c;
        long n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}