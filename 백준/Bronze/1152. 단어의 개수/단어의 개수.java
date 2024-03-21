import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int c, p = System.in.read(), count = 0;
        while (true) {
            c = System.in.read();
            if (p != 32 && (c == 32 || c == 10)) count++;
            if (c == 10) break;
            p = c;
        }
        System.out.println(count);
    }
}