import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n = 30;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitted = new boolean[n + 1];
        
        for (int i = 0; i < n - 2; i++) submitted[Integer.parseInt(br.readLine())] = true;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) if (!submitted[i]) sb.append(i).append('\n');
        System.out.println(sb);
    }
}