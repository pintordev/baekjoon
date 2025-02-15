import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int t = read();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    public static int solve() throws IOException {
        int n = read();
        int m = read();

        Request[] requests = new Request[m];
        for (int i = 0; i < m; i++) {
            requests[i] = new Request(read(), read());
        }
        Arrays.sort(requests);

        boolean[] check = new boolean[n + 1];
        int cnt = 0;
        for (Request request : requests) {
            for (int i = request.a; i <= request.b; i++) {
                if (check[i]) continue;
                check[i] = true;
                cnt++;
                break;
            }
        }
        return cnt;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Request implements Comparable<Request> {
    int a;
    int b;

    public Request(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Request o) {
        return this.b - o.b;
    }
}