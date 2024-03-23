import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = read();
        int[] num = new int[10001];
        for (int i = 0; i < n; i++) num[read()]++;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            while (num[i]-- > 0) sb.append(i).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
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