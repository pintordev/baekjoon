import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        int[] min = new int[3];
        int[] max = new int[3];
        int[] arr, temp;
        while (n-- > 0) {
            arr = new int[]{read(), read(), read()};

            temp = min.clone();
            min[0] = Math.min(temp[0], temp[1]) + arr[0];
            min[1] = Math.min(Math.min(temp[0], temp[1]), temp[2]) + arr[1];
            min[2] = Math.min(temp[1], temp[2]) + arr[2];

            temp = max.clone();
            max[0] = Math.max(temp[0], temp[1]) + arr[0];
            max[1] = Math.max(Math.max(temp[0], temp[1]), temp[2]) + arr[1];
            max[2] = Math.max(temp[1], temp[2]) + arr[2];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(Math.max(max[0], max[1]), max[2])).append(' ').append(Math.min(Math.min(min[0], min[1]), min[2]));
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