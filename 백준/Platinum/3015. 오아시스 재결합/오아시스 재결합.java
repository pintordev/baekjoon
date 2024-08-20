import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = read();

        Node[] s = new Node[n];
        int top = -1;
        long cnt = 0;

        for (int i = 0; i < n; i++) {
            int h = read();
            int c = 1;

            while (top != -1 && s[top].h <= h) {
                cnt += s[top].c;
                if (s[top].h == h) c += s[top].c;
                top--;
            }

            if (top != -1) cnt++;

            s[++top] = new Node(h, c);
        }

        System.out.println(cnt);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node {
    int h;
    int c;

    Node(int h, int c) {
        this.h = h;
        this.c = c;
    }
}