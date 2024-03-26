import java.io.*;

class Main {

    public static int k;
    public static int s = -1;
    public static int c = 0;

    public static void main(String[] args) throws IOException {

        int n = read();
        k = read();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = read();

        mergeSort(a, 0, n - 1);
        System.out.println(s);
    }

    public static void mergeSort(int[] a, int p, int r) {

        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    public static void merge(int[] a, int p, int q, int r) {

        int[] temp = new int[r - p + 1];
        int i = p, j = q + 1, t = 0;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) temp[t++] = a[i++];
            else temp[t++] = a[j++];
        }
        while (i <= q) temp[t++] = a[i++];
        while (j <= r) temp[t++] = a[j++];

        i = p; t = 0;
        while (i <= r) {
            c++;
            if (c == k) {
                s = temp[t];
                break;
            }
            a[i++] = temp[t++];
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