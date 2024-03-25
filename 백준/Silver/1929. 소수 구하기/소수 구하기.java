import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int m = read(), n = read();
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (isPrime(i)) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int n) {
        if (n == 2) return true;
        if (n < 2 || n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
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