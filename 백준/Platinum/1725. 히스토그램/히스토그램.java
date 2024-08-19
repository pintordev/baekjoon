import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        int[] s = new int[n];
        int top = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            while (top != -1 && arr[s[top]] > arr[i]) {
                int height = arr[s[top--]];
                int width = top == -1 ? i : i - s[top] - 1;
                max = Math.max(max, height * width);
            }
            s[++top] = i;
        }
        while (top != -1) {
            int height = arr[s[top--]];
            int width = top == -1 ? n : n - s[top] - 1;
            max = Math.max(max, height * width);
        }
        System.out.println(max);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}