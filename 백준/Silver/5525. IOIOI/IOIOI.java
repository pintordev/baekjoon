import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int whole = 0;
        for (int i = 0; i < m - 2; i++) {
            int local = 0;
            while (i < m - 2 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                local++;
                i += 2;
            }
            if (local >= n) whole += local - n + 1;
        }
        System.out.println(whole);
    }
}