import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = read();
        }

        int gcd = gcd(numbers);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static int gcd(int[] numbers) {
        int gcd = Math.abs(numbers[0] - numbers[1]);
        for (int i = 2; i < numbers.length; i++) {
            gcd = gcd(gcd, Math.abs(numbers[i] - numbers[i - 1]));
        }
        return gcd;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}