import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 2 * n; i++) {
            int star = n - Math.abs(--m);
            sb.append("*".repeat(star));
            sb.append(" ".repeat(2 * (n - star)));
            sb.append("*".repeat(star));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}