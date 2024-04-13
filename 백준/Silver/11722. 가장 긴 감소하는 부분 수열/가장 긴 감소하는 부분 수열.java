import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int[] memo = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            max = Math.max(max, memo[i]);
        }
        System.out.println(max);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}