import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int sum = 0;
            char[] c = br.readLine().toCharArray();
            for (char ch : c) {
                if (ch == '(') sum++;
                else sum--;
                if (sum < 0) break;
            }
            sb.append(sum == 0 ? "YES" : "NO").append('\n');
        }
        System.out.println(sb);
    }
}