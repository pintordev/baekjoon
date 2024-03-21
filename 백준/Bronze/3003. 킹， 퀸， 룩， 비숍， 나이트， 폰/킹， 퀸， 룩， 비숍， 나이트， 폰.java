import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        int[] s = {1, 1, 2, 2, 2, 8};
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i] - Integer.parseInt(st.nextToken())).append(' ');
        }
        System.out.println(sb);
    }
}