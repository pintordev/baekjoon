import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        List<Integer> lis = new ArrayList<>();
        lis.add(read());
        for (int i = 1; i < n; i++) {
            int num = read();
            if (lis.get(lis.size() - 1) < num) {
                lis.add(num);
                continue;
            }

            int low = 0;
            int high = lis.size() - 1;
            while (low + 1 < high) {
                int mid = (low + high) >> 1;
                if (lis.get(mid) < num) low = mid;
                else high = mid;
            }

            if (lis.get(low) >= num) lis.set(low, num);
            else lis.set(high, num);
        }
        System.out.println(lis.size());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}