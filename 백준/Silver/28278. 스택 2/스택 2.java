import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] stack = new int[n];
        int idx = -1;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int c = read();
            if (c == 1) {
                stack[++idx] = read();
            } else if (c == 2) {
                if (idx > -1) {
                    sb.append(stack[idx--]).append('\n');
                } else {
                    sb.append(idx).append('\n');
                }
            } else if (c == 3) {
                sb.append(idx + 1).append('\n');
            } else if (c == 4) {
                sb.append(idx == -1 ? 1 : 0).append('\n');
            } else if (c == 5) {
                if (idx > -1) {
                    sb.append(stack[idx]).append('\n');
                } else {
                    sb.append(idx).append('\n');
                }
            }
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