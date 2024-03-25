import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), m = read();
        Set<String> set = new HashSet<>();
        while (n-- > 0) set.add(new String(readChars()));

        int count = 0;
        while (m-- > 0) {
            if (set.contains(new String(readChars()))) count++;
        }
        System.out.println(count);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[500];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }
}