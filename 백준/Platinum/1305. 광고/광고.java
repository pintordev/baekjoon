import java.io.IOException;

public class Main {
    public static String p;
    public static int pLen;
    public static int[] pi;

    public static void main(String[] args) throws IOException {
        int l = read();
        p = readString();
        pLen = p.length();

        pi = new int[pLen];
        getPi();

        System.out.println(l - pi[pLen - 1]);
    }

    public static void getPi() {
        int j = 0;
        for (int i = 1; i < pLen; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) pi[i] = ++j;
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 13) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}