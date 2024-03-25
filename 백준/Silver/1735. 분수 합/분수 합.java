import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int a = read(), b = read(), c = read(), d = read();
        int num = a * d + b * c, den = b * d;
        int min = Math.min(num, den), max = Math.max(num, den);
        while (max % min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(num / min).append(' ').append(den / min);
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