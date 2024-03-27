import java.io.IOException;

class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = read();
        sb.append((int) Math.pow(2, n) - 1).append('\n');
        hanoi(n, 1, 3, 2);
        System.out.println(sb);
    }

    public static void hanoi(int n, int s, int e, int m) {
        if (n == 0) return;
        hanoi(n - 1, s, m, e);
        sb.append(s).append(' ').append(e).append('\n');
        hanoi(n - 1, m, e, s);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}