import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = read();

        if (n <= 10) System.out.println(n);
        else if (n > 1022) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                dfs(i, 1);
            }
            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    public static void dfs(long num, int idx) {
        if (idx > 10) return;
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs(num * 10 + i, idx + 1);
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}