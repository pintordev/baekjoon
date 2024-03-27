import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            cantor(n);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void cantor(int n) {
        int len = (int) Math.pow(3, n);
        if (len == 1) {
            sb.append('-');
            return;
        }
        cantor(n - 1);
        sb.append(" ".repeat(len / 3));
        cantor(n - 1);
    }
}