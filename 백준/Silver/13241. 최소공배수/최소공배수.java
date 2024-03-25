import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        long a = read(), b = read();
        long min = Math.min(a, b), max = Math.max(a, b);
        while (max % min != 0) {
            long r = max % min;
            max = min;
            min = r;
        }
        System.out.println(a * b / min);
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}