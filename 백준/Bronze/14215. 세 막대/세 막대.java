import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int[] lines = {read(), read(), read()};
        Arrays.sort(lines);
        while (lines[2] >= lines[0] + lines[1]) lines[2]--;
        System.out.println(lines[0] + lines[1] + lines[2]);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}