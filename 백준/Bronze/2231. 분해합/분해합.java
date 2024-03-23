import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int m = n, len = 0, con = 0;
        while (m > 0) {
            m /= 10;
            len++;
        }
        
        for (int i = n - 9 * len; i < n; i++) {
            if (isCon(i, n)) {
                con = i;
                break;
            }
        }
        System.out.println(con);
    }

    private static boolean isCon(int i, int n) {
        int sum = i;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum == n;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}