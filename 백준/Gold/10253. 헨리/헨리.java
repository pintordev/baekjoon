import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int a = read(), b = read();
            int c = 0;
            while (a * (c = henry(a, b)) != b) {
                a = a * c - b;
                b *= c;
            }
            sb.append(c).append('\n');
        }
        System.out.print(sb);
    }

    public static int henry(int a, int b) {
        int n = b / a;
        if (n * a >= b) return n;
        return n + 1;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}