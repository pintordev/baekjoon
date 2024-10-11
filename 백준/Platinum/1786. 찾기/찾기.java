import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String t;
    public static String p;
    public static int tLen;
    public static int pLen;
    public static int[] pi;
    public static List<Integer> idx;

    public static void main(String[] args) throws IOException {
        t = readString();
        p = readString();

        tLen = t.length();
        pLen = p.length();

        pi = new int[pLen];
        getPi();

        idx = new ArrayList<>();
        kmp();

        StringBuilder sb = new StringBuilder();
        sb.append(idx.size()).append('\n');
        for (int i : idx) {
            sb.append(i + 1).append(' ');
        }
        System.out.println(sb);
    }

    public static void getPi() {
        int j = 0;
        for (int i = 1; i < pLen; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) pi[i] = ++j;
        }
    }

    public static void kmp() {
        int j = 0;
        for (int i = 0; i < tLen; i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == pLen - 1) {
                    idx.add(i - pLen + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static String readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 13) {
            sb.append((char) c);
        }
        return sb.toString();
    }
}