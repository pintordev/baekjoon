import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = read();

        boolean[] pop = new boolean[n];
        StringBuilder sb = new StringBuilder();
        int pdx = 0, k = 0;
        for (int i = 0; i < n; i++) {
            while (Math.abs(k) > 0) {
                if (k < 0) {
                    pdx = (pdx - 1 + n) % n;
                    if (!pop[pdx]) k++;
                } else {
                    pdx = (pdx + 1) % n;
                    if (!pop[pdx]) k--;
                }
            }
            pop[pdx] = true;
            sb.append(pdx + 1).append(' ');
            k = num[pdx];
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