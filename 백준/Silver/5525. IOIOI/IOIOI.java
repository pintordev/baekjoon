import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String sub = new StringBuilder("IO".repeat(n)).append('I').toString();
        int subLen = 2 * n + 1;
        int count = 0;
        for (int i = 0; i <= m - subLen; i++) {
            if (s.charAt(i) == 'O') continue;
            if (s.substring(i, i + subLen).equals(sub)) count++;
        }
        System.out.println(count);
    }
}