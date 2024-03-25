import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), m = read();
        Set<Integer> A = new HashSet<>(), B = new HashSet<>();

        while (n-- > 0) A.add(read());

        while (m-- > 0) {
            int i = read();
            if (A.contains(i)) A.remove(i);
            else B.add(i);
        }

        System.out.println(A.size() + B.size());
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}