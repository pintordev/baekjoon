import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int m = read(), n = read();
        int first = 0, sum = 0;
        for (int i = m; i <= n; i++) {
            if (!isPrime(i)) continue;
            sum += i;
            if (first == 0) first = i;
        }
        if (sum > 0) System.out.printf("%d\n%d\n", sum, first);
        else System.out.println("-1");
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}