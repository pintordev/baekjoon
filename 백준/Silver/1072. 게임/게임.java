import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        long x = (long) read();
        long y = (long) read();
        long z = y * 100 / x;

        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        long low = 0;
        long high = 1000000000;
        while (low + 1 < high) {
            long mid = (low + high) >>> 1;
            long nz = (y + mid) * 100 / (x + mid);

            if (nz <= z) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(high);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}