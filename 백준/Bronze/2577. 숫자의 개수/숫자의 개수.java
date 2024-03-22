import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int[] digits = new int[10];

        int n = read() * read() * read();
        while (n > 0) {
            digits[n % 10]++;
            n /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int digit : digits) sb.append(digit).append('\n');
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}