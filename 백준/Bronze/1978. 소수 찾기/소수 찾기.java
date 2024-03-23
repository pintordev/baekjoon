import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), count = 0;
        while (n-- > 0) {
            if (isPrime(read())) count++;
        }
        System.out.println(count);
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