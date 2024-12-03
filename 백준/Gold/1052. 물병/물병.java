import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        int min = 0;
        while (Integer.bitCount(n) > k) {
            min += n & -n;
            n += n & -n;
        }
        System.out.println(min);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}