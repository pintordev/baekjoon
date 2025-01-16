import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int k = read();

        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            if (k % 2 == 0) sb.append(7);
            else sb.append(4);
            k = --k >> 1;
        }
        System.out.println(sb.reverse());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}