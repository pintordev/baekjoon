import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] scores = new int[79];
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int c, sum = 0, idx = 0;
            while ((c = System.in.read()) > 32) {
                if (c == 'X') scores[idx++] = 0;
                else {
                    scores[idx] = idx == 0 ? 1 : scores[idx - 1] + 1;
                    sum += scores[idx++];
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}