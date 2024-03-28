import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        int k = read(), n = read();
        int[] lan = new int[k];
        long l = 1, h = 0;
        for (int i = 0; i < k; i++) {
            lan[i] = read();
            h = Math.max(h, lan[i]);
        }

        while (l <= h) {
            long mid = (l + h) / 2;
            if (split(mid, lan) < n) h = mid - 1;
            else l = mid + 1;
        }

        System.out.println(h);
    }

    public static int split(long mid, int[] lan) {
        int sum = 0;
        for (int l : lan) sum += l / mid;
        return sum;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}