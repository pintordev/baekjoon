import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return  1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}