import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        while (true) {
            int[] lines = {read(), read(), read()};
            if (lines[0] == 0) break;
            Arrays.sort(lines);
            if (lines[2] >= lines[0] + lines[1]) System.out.println("Invalid");
            else {
                if (lines[0] == lines[1] && lines[1] == lines[2]) System.out.println("Equilateral");
                else if (lines[0] == lines[1] || lines[1] == lines[2] || lines[2] == lines[1]) System.out.println("Isosceles");
                else System.out.println("Scalene");
            }
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