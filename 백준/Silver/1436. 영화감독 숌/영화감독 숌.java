import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), i = 665;
        while (n > 0) {
            if (apocalypse(++i)) n--;
        }
        System.out.println(i);
    }

    public static boolean apocalypse(int i) {
        int count = 0;
        while (i > 0 && count < 3) {
            if (i % 10 == 6) count++;
            else count = 0;
            i /= 10;
        }
        return count == 3;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}