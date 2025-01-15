import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * pow(2, i);
            sum -= arr[i] * pow(2, n - i - 1);
            sum %= mod;
        }
        System.out.println(sum);
    }

    public static long pow(int base, int exp) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2);
        if (exp % 2 == 0) return half * half % mod;
        return half * half * base % mod;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}