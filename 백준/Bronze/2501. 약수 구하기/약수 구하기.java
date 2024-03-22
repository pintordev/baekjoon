import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), k = read();
        int[] fs = new int[k + 1];
        int j = 1;
        for (int i = 1; i <= n && j <= k; i++) {
            if (n % i == 0) fs[j++] = i;
        }
        System.out.println(fs[k]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}