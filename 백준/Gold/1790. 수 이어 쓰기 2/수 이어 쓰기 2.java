import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int k = read();

        long len = 1;
        long cnt = 9;
        while (k > len * cnt) {
            k -= len * cnt;
            len++;
            cnt *= 10;
        }
        k -= 1;

        long num = (long) Math.pow(10, len - 1) + k / len;
        if (num > n) System.out.println(-1);
        else System.out.println(String.valueOf(num).charAt((int) (k % len)));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}