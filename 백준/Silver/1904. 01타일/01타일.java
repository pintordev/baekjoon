import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int mod = 15746;

        int n = read();
        if (n < 3) {
            System.out.println(n);
            return;
        }

        int a = 1, b = 2, c = 0;
        for (int i = 3; i <= n; i++) {
            c = (a + b) % mod;
            a = b; b = c;
        }
        System.out.println(c);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}