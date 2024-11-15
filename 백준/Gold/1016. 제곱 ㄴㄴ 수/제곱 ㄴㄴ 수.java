import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long min = read();
        long max = read();

        int count = (int) (max - min + 1);
        boolean[] isNotSquare = new boolean[count];
        for (long i = 2; i * i <= max; i++) {
            long p = i * i;
            long j = (min + p - 1) / p;
            for (; j * p <= max; j++) {
                int idx = (int) (j * p - min);
                if (!isNotSquare[idx]) {
                    isNotSquare[idx] = true;
                    count--;
                }
            }
        }
        System.out.println(count);
    }

    public static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}