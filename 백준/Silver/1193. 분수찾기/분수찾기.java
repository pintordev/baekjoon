import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), i = 1;
        while (n > 0) n -= i++;
        int a = i % 2 == 0 ? 1 - n : n + i - 1;
        int b = i % 2 == 0 ? n + i - 1 : 1 - n;
        StringBuilder sb = new StringBuilder()
                .append(a)
                .append('/')
                .append(b);
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