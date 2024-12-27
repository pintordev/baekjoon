import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int sum = 0;
        int one = 0;
        int two = 0;
        while(n-- > 0) {
            int a = read();
            sum += a;
            one += a / 2;
            two += a % 2;
        }

        System.out.println(sum % 3 == 0 && one >= two ? "YES" : "NO");
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}