import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int m = read();

        boolean[] set = new boolean[21];
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String cmd = readString();
            if (cmd.equals("all")) {
                Arrays.fill(set, true);
                continue;
            } else if (cmd.equals("empty") ) {
                Arrays.fill(set, false);
                continue;
            }

            int x = read();
            if (cmd.equals("add")) {
                set[x] = true;
            } else if (cmd.equals("remove")) {
                set[x] = false;
            } else if (cmd.equals("check")) {
                if (set[x]) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (cmd.equals("toggle")) {
                set[x] = !set[x];
            }
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}