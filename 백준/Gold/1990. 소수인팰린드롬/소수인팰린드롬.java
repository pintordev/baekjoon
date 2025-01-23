import java.io.IOException;

public class Main {
    public static boolean[] complex;

    public static void main(String[] args) throws IOException {
        int a = read(), b = read();

        eratosthenes(b);

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (!complex[i] && isPalindrome(i)) {
                sb.append(i).append('\n');
            }
        }
        sb.append(-1);
        System.out.println(sb);
    }

    public static void eratosthenes(int b) {
        complex = new boolean[b + 1];
        complex[0] = complex[1] = true;
        for (int i = 2; i * i <= b; i++) {
            if (complex[i]) continue;
            for (int j = i * i; j <= b; j += i) {
                complex[j] = true;
            }
        }
    }

    public static boolean isPalindrome(int n) {
        char[] c = String.valueOf(n).toCharArray();
        for (int i = 0; i < c.length / 2; i++) {
            if (c[i] != c[c.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}