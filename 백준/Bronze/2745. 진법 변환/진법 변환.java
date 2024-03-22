import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        char[] n = readChars();
        int b = readInt();

        int f = 1, dec = 0;
        for (int i = n.length - 1; i >= 0; i--) {
            dec += f * toDec(n[i]);
            f *= b;
        }

        System.out.println(dec);
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[35];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }

    public static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static int toDec(char c) {
        if (c >= 'A') return c - 55;
        else return c - '0';
    }
}