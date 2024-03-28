import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int a = read(), b = read();
        int gcd = gcd(a, b);
        StringBuilder sb = new StringBuilder();
        sb.append(gcd).append('\n').append(a * b / gcd);
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        int min = Math.min(a, b), max = Math.max(a, b);
        while (max % min != 0) {
            int r = max % min;
            max = min;
            min = r;
        }
        return min;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}