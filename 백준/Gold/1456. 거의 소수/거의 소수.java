import java.io.IOException;

public class Main {
    public static int len;
    public static boolean[] complex;

    public static void main(String[] args) throws IOException {
        long a = read();
        long b = read();

        len = (int) Math.sqrt(b);
        eratosthenes();

        int cnt = 0;
        for (int i = 2; i <= len; i++) {
            if (complex[i]) continue;
            long num = i;
            while (num <= (double) b / i) {
                if (num >= (double) a / i) cnt++;
                num *= i;
            }
        }
        System.out.println(cnt);
    }

    public static void eratosthenes() {
        complex = new boolean[len + 1];
        complex[0] = complex[1] = true;
        for (int i = 2; i * i <= len; i++) {
            if (complex[i]) continue;
            for (int j = i * i; j <= len; j += i) {
                complex[j] = true;
            }
        }
    }

    public static long read() throws IOException {
        int c;
        long n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}