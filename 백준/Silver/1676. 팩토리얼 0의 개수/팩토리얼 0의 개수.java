import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int f = 5;
        int sum = 0;
        while (f <= n) {
            sum += n / f;
            f *= 5;
        }
        System.out.println(sum);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}