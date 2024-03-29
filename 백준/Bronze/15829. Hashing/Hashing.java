import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int l = read();
        int mod = 1234567891;
        int hash = 0;
        int factor = 1;
        for (int i = 0; i < l; i++) {
            int c = System.in.read() - 96;
            hash += c * (factor % mod) % mod;
            factor = 31 * (factor % mod) % mod;
        }
        System.in.read();
        System.out.println(hash);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}