import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int[] a = new int[n];
        int[] cnt = new int[1000001];
        for (int i = 0; i < n; i++) {
            a[i] = read();
            cnt[a[i]]++;
        }

        int[] r = new int[n];
        int[] s = new int[n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            while (top != -1 && cnt[a[s[top]]] < cnt[a[i]]) {
                r[s[top--]] = a[i];
            }
            s[++top] = i;
        }
        while (top != -1) {
            r[s[top--]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(r[i]).append(' ');
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