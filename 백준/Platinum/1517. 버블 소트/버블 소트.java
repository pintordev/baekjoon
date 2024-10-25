import java.io.IOException;

public class Main {
    public static int[] arr;
    public static int[] temp;
    public static long cnt;

    public static void main(String[] args) throws IOException {
        int n = read();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        temp = new int[n];
        cnt = 0;
        mergeSort(0, n - 1);
        System.out.println(cnt);
    }

    public static void mergeSort(int s, int e) {
        if (s < e) {
            int mid = (s + e) >> 1;
            mergeSort(s, mid);
            mergeSort(mid + 1, e);
            merge(s, mid, e);
        }
    }

    public static void merge(int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = s;

        while (i <= mid && j <= e) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                cnt += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= e) {
            temp[k++] = arr[j++];
        }

        for (int l = s; l <= e; l++) {
            arr[l] = temp[l];
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