import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read(), count = 0;
        while (n-- > 0) {
            int[] ch = new int[26];
            int c, p = -1;
            boolean b = true;
            while ((c = System.in.read()) != 10) {
                if (c != p && ch[c - 97] > 0) {
                    b = false;
                    while ((c = System.in.read()) != 10) {}
                    break;
                }
                ch[c - 97]++;
                p = c;
            }
            if (b) count++;
        }

        System.out.println(count);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) != 10) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}