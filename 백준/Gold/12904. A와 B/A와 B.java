import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder s = readString();
        StringBuilder t = readString();

        while (s.length() < t.length()) {
            char c = t.charAt(t.length() - 1);

            if (c == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else if (c == 'B') {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        System.out.println(s.toString().equals(t.toString()) ? 1 : 0);
    }

    public static StringBuilder readString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = System.in.read()) > 32) {
            sb.append((char) c);
        }
        return sb;
    }
}