import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) f[i] = read();
        Arrays.sort(f);
        System.out.println(f[0] * f[n - 1]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}