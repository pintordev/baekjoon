import java.io.IOException;

class Main {

    public static int count = 0;

    public static void main(String[] args) throws IOException {

        int n = read();
        int r = read();
        int c = read();

        int len = (int) Math.pow(2, n);
        splitZ(r, c, len);
        System.out.println(count);
    }

    public static void splitZ(int i, int j, int len) {

        if (len == 1) return;

        int subLen = len / 2;
        if (i < subLen && j >= subLen) {
            count += subLen * subLen;
            j -= subLen;
        } else if (i >= subLen && j < subLen) {
            count += 2 * subLen * subLen;
            i -= subLen;
        } else if (i >= subLen && j >= subLen) {
            count += 3 * subLen * subLen;
            i -= subLen;
            j -= subLen;
        }

        splitZ(i, j, len / 2);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}