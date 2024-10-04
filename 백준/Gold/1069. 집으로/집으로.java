import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int x = read();
        int y = read();
        int d = read();
        int t = read();

        double len = Math.sqrt(x * x + y * y);

        double time = len;
        if (len >= d) {
            int n = (int) (len / d);
            time = Math.min(time, len - n * d + n * t);
            time = Math.min(time, (n + 1) * t);
        } else {
            time = Math.min(time, t + d - len);
            time = Math.min(time, 2 * t);
        }
        System.out.println(time);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}