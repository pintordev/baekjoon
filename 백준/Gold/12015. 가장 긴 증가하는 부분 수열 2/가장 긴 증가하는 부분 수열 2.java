import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] lis = new int[n];
        lis[0] = read();
        int idx = 0;
        for (int i = 1; i < n; i++) {
            int num = read();
            if (lis[idx] < num) {
                lis[++idx] = num;
                continue;
            }

            int low = 0;
            int high = idx;
            while (low + 1 < high) {
                int mid = (low + high) >> 1;
                if (lis[mid] < num) low = mid;
                else high = mid;
            }

            if (lis[low] >= num) lis[low] = num;
            else lis[high] = num;
        }
        System.out.println(++idx);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}