import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String s;
    public static String t;
    public static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        limit = t.length() - s.length();
        recursion(s, 0);
        System.out.println(0);
    }

    public static void recursion(String s, int depth) {
        if (depth == limit) {
            if (s.equals(t)) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }
        if (!t.contains(s) && !t.contains(new StringBuilder(s).reverse().toString())) {
            return;
        }
        recursion(new StringBuilder(s).append('A').toString(), depth + 1);
        recursion(new StringBuilder(s).append('B').reverse().toString(), depth + 1);
    }
}