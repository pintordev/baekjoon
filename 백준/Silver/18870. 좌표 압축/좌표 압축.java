import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] num = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            num[i] = read();
            map.put(num[i], 0);
        }

        int idx = 0;
        for (int key : map.keySet()) map.put(key, idx++);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(num[i])).append(' ');
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
}