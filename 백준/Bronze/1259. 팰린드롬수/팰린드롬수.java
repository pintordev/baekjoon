import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = read()) != 0) {
            char[] c = (n + "").toCharArray();
            boolean b = true;
            for (int i = 0; i <= c.length / 2; i++) {
                if (c[i] != c[c.length - 1 - i]) {
                    b = false;
                    break;
                }
            }
            if (b) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
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