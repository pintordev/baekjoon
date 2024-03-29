import java.io.IOException;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) score[i] = read();
        Arrays.sort(score);

        int cut = (int) Math.round(n * 0.15);
        int sum = 0;
        for (int i = cut; i < n - cut; i++) sum += score[i];
        System.out.println(Math.round((double) sum / (n - 2 * cut)));
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}