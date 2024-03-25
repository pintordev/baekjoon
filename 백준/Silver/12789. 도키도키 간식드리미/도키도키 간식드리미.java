import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n = read();
        int i = 1;
        Stack<Integer> wait = new Stack<>();
        while (n-- > 0) {
            int last = read();
            if (last == i) i++;
            else wait.add(last);

            while (!wait.isEmpty() && wait.peek() == i) {
                wait.pop();
                i++;
            }
        }

        if (wait.isEmpty()) System.out.println("Nice");
        else System.out.println("Sad");
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}