import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        memo1[0] = arr[0];
        memo2[0] = arr[0];

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            memo1[i] = Math.max(memo1[i - 1] + arr[i], arr[i]);
            memo2[i] = Math.max(memo1[i - 1], memo2[i - 1] + arr[i]);
            max = Math.max(max, Math.max(memo1[i], memo2[i]));
        }
        System.out.println(max);
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