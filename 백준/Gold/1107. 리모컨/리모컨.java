import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        if (m > 0) {
            String[] input = br.readLine().split(" ");
            while (m-- > 0) {
                broken[Integer.parseInt(input[m])] = true;
            }
        }

        int min = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (broken[s.charAt(j) - '0']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int cnt = len + Math.abs(n - i);
                min = Math.min(min, cnt);
            }
        }
        System.out.println(min);
    }
}