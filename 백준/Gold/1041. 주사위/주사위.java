import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = read();
        }

        int[] min = new int[]{
                Math.min(dice[0], dice[5]),
                Math.min(dice[1], dice[4]),
                Math.min(dice[2], dice[3])
        };
        Arrays.sort(min);

        long[] max = new long[]{
                4L,
                8L * (n - 2) + 4L,
                5L * (n - 2) * (n - 2) + 4L * (n - 2)
        };

        if (n == 1) {
            Arrays.sort(dice);
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
        } else {
            System.out.println(max[0] * (min[0] + min[1] + min[2]) + max[1] * (min[0] + min[1]) + max[2] * min[0]);
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}