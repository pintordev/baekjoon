import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] cards = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, cards[i] = read());
        }

        int[] memo = new int[max + 1];
        for (int i = 0; i < n; i++) {
            memo[cards[i]] = i + 1;
        }

        int[] pos = new int[n + 1];
        for (int card : cards) {
            for (int i = card << 1; i <= max; i += card) {
                if (memo[i] == 0) continue;
                pos[memo[i]]--;
                pos[memo[card]]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(pos[i]).append(' ');
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