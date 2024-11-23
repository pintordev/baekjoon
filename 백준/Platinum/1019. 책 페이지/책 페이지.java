import java.io.IOException;

public class Main {
    public static int[] cnt = new int[10];

    public static void main(String[] args) throws IOException {
        simulate(read());
    }

    public static void simulate(int e) {
        int digit = 1;
        int s = 1;

        while (s <= e) {
            while (s % 10 != 0 && s <= e) {
                count(s, digit);
                s++;
            }
            while (e % 10 != 9 && s <= e) {
                count(e, digit);
                e--;
            }

            if (s > e) break;
            s /= 10;
            e /= 10;

            for (int i = 0; i < 10; i++) {
                cnt[i] += (e - s + 1) * digit;
            }
            digit *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(cnt[i]).append(' ');
        }
        System.out.println(sb);
    }

    public static void count(int num, int digit) {
        while (num > 0) {
            cnt[num % 10] += digit;
            num /= 10;
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