import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int s = read();
        for (int i = 0;  i < n && s > 0; i++) {
            int mdx = i;
            for (int j = i + 1; j < n && j - i <= s; j++) {
                if (arr[j] > arr[mdx]) mdx = j;
            }

            for (int j = mdx; j > i; j--) {
                int t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
            }

            s -= mdx - i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
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