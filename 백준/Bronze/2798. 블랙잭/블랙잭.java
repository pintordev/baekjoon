import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), m = read();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = read();

        int max = choose(cards, m, new boolean[n], 0, 0, 0, 0);
        System.out.println(max);
    }

    private static int choose(int[] cards, int m, boolean[] chosen, int start, int count, int sum, int max) {

        if (max == m) return max;
        if (count == 3) {
            if (sum <= m) max = Math.max(sum, max);
            return max;
        }

        for (int i = start; i < cards.length; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                max = Math.max(choose(cards, m, chosen, i, count + 1, sum + cards[i], max), max);
                chosen[i] = false;
            }
        }

        return max;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}