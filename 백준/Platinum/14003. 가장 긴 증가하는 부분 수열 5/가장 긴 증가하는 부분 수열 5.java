import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] idx = new int[n];
        int size = 0;
        int num = read();
        arr[0] = num;
        lis[0] = num;
        idx[0] = size;
        for (int i = 1; i < n; i++) {
            num = read();
            arr[i] = num;

            if (lis[size] < num) {
                lis[++size] = num;
                idx[i] = size;
                continue;
            }

            int low = 0;
            int high = size;
            while (low + 1 < high) {
                int mid = (low + high) / 2;
                if (lis[mid] < num) low = mid;
                else high = mid;
            }

            if (lis[low] >= num) high = low;
            lis[high] = num;
            idx[i] = high;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(size + 1).append('\n');
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (idx[i] != size) continue;
            stack.push(arr[i]);
            size--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.println(sb);
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