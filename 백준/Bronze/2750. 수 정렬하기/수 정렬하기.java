import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = read();
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(num[i]).append('\n');
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