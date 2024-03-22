import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int[] coins = {25, 10, 5, 1};

        StringBuilder sb = new StringBuilder();
        int n = read();
        while (n-- > 0) {
            int price = read();
            for (int i = 0; i < 4; i++) {
                sb.append(price / coins[i]).append(' ');
                price %= coins[i];
            }
            sb.append('\n');
        }
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