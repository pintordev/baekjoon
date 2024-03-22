import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        boolean a = true, d = true;
        for (int i = 1; i <= 8 && (a || d); i++) {
            int n = read();
            if (a && n != i) a = false;
            if (d && n != 9 - i) d = false;
        }
        if (a) System.out.println("ascending");
        else if (d) System.out.println("descending");
        else System.out.println("mixed");
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}