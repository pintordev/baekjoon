import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] seq;

    public static void main(String[] args) throws IOException {

        int n = read();
        int m = read();

        seq = new int[m];

        sequence(n, m, 0);
        bw.flush();
    }

    public static void sequence(int n, int m, int depth) throws IOException {
        if (depth == m) {
            for (int s : seq) {
                bw.write(s + 48);
                bw.write(' ');
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < n; i++) {
            seq[depth] = i + 1;
            sequence(n, m, depth + 1);
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