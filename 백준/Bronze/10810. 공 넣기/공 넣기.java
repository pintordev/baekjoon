import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] basket = new int[Integer.parseInt(st.nextToken())];
        int m = Integer.parseInt(st.nextToken());
        
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (; i <= j; i++) {
                basket[i - 1] = k;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int b : basket) {
            sb.append(b).append(' ');
        }
        System.out.println(sb);
    }
}