import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        
        Counsel[] counsels = new Counsel[n + 2];
        for (int i = 1; i <= n; i++) {
            counsels[i] = new Counsel(read(), read());
        }
        counsels[n + 1] = new Counsel(0, 0);
        
        int[] memo = new int[n + 2];
        int max = -1;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, memo[i]);
            
            int next = i + counsels[i].t;
            if (next < n + 2) memo[next] = Math.max(memo[next], max + counsels[i].p);
        }
        System.out.println(memo[n + 1]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Counsel {
    int t;
    int p;
    
    public Counsel(int t, int p) {
        this.t = t;
        this.p = p;
    }
}