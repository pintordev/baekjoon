import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int t = (int) read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = read();
            while (!isPrime(n)) n++;
            sb.append(n).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}