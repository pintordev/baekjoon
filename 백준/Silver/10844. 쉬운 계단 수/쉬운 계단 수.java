import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] memo = new int[12];
        for (int i = 2; i < 11; i++) {
            memo[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int[] temp = new int[12];
            for (int j = 1; j < 11; j++) {
                temp[j] = (memo[j - 1] + memo[j + 1]) % 1000000000;
            }
            memo = temp;
        }

        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum = (sum + memo[i]) % 1000000000;
        }
        System.out.println(sum);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}