import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long n = read();
        System.out.println(n % 5 == 0 || n % 5 == 2 ? "CY" : "SK");
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}