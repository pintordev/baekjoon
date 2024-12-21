import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        if (n == 1 || (n == 2 && arr[0] != arr[1])) {
            System.out.println("A");
            return;
        }

        if (n == 2) {
            System.out.println(arr[0]);
            return;
        }

        int diff = arr[1] - arr[0];
        int a = 0, b = 0;
        if (diff == 0) {
            a = 1;
            b = 0;
        } else {
            a = (arr[2] - arr[1]) / diff;
            b = arr[1] - arr[0] * a;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1] * a + b) {
                System.out.println("B");
                return;
            }
        }

        System.out.println(arr[n - 1] * a + b);
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