import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        Set<Integer> set = new HashSet<>();
        int n = read();
        while (n-- > 0) set.add(read());

        StringBuilder sb = new StringBuilder();
        n = read();
        while (n-- > 0) sb.append(set.contains(read()) ? 1 : 0).append(' ');
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
}