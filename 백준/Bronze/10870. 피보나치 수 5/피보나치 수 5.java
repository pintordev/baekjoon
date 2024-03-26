import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] f = new int[n + 1];
        if (n > 0) f[1] = 1;
        for (int i = 2; i <= n; i++) f[i] = f[i - 1] + f[i - 2];
        System.out.println(f[n]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}