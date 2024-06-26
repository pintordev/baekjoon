import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int sum = 0;
        while (n > 0) {
            n /= 5;
            sum += n;
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