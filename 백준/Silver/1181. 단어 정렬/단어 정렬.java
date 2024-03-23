import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        Set<String> set = new TreeSet<>((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });
        for (int i = 0; i < n; i++) set.add(new String(readChars()));

        StringBuilder sb = new StringBuilder();
        for (String s : set) sb.append(s).append('\n');
        System.out.println(sb);
    }

    public static char[] readChars() throws IOException {
        char[] c = new char[50];
        int idx = 0, ch;
        while ((ch = System.in.read()) > 32) c[idx++] = (char) ch;
        return Arrays.copyOf(c, idx);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}