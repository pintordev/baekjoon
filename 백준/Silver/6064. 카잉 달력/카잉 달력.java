import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        L:
        while (t-- > 0) {
            int n = read();
            int m = read();
            int x = read();
            int y = read();

            int cnt = x;
            int i = x - 1;
            int j = (x - 1) % m;
            int limit = lcm(n, m);
            while (cnt <= limit) {
                if (j == y - 1) {
                    sb.append(cnt).append('\n');
                    continue L;
                }
                cnt += n;
                j = (j + n) % m;
            }
            sb.append(-1).append('\n');
        }
        System.out.println(sb);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
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