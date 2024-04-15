import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String s;
    public static int limit;
    public static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        String t = br.readLine();
        limit = t.length() - s.length();
        recursion(t, 0);
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void recursion(String t, int depth) {
        if (flag) {
            return;
        }
        if (depth == limit) {
            if (t.equals(s)) {
                flag = true;
            }
            return;
        }
        if (t.charAt(t.length() - 1) == 'A') {
            recursion(t.substring(0, t.length() - 1), depth + 1);
        }
        if (t.charAt(0) == 'B') {
            recursion(new StringBuilder(t.substring(1)).reverse().toString(), depth + 1);
        }
    }
}