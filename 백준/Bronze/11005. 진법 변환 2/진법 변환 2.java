import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), b = read();
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(toNotation(n % b));
            n /= b;
        }
        System.out.println(sb.reverse());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static char toNotation(int n) {
        if (n < 10) return (char) (n + '0');
        else return (char) (n + 55);
    }
}