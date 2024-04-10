import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int m = Integer.parseInt(br.readLine());
        if (m > 0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(input[i])] = true;
            }
        }

        int min = Math.abs(n - 100);
        for (int i = 0; i < 1000000; i++) {
            int len = lenIfCanMove(i);
            if (len == 0) {
                continue;
            }
            min = Math.min(min, len + Math.abs(n - i));
        }

        System.out.println(min);
    }

    public static int lenIfCanMove(int i) {
        if (i == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int len = 0;
        while (i > 0) {
            if (broken[i % 10]) {
                return 0;
            }
            len++;
            i /= 10;
        }
        return len;
    }
}