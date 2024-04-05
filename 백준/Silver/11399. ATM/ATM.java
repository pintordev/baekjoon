import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = read();
        }
        
        Arrays.sort(p);

        int take = p[0];
        for (int i = 1; i < n; i++) {
            p[i] += p[i - 1];
            take += p[i];
        }

        System.out.println(take);
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}