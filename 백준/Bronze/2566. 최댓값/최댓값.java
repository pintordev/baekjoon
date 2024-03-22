import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int max = Integer.MIN_VALUE, idx = -1, jdx = -1;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int n = read();
                if (max < n) {
                    max = n;
                    idx = i;
                    jdx = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n')
                .append(idx).append(' ').append(jdx);
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