import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int[] num = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            num[i] = read();
            sum += num[i];
        }
        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        sb.append(sum / 5).append('\n').append(num[2]);
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