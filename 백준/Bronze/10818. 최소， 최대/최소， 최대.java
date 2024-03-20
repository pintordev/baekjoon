import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(n-- > 0) {
            int i = Integer.parseInt(st.nextToken());
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        System.out.printf("%d %d", min, max);
    }
}