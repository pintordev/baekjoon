import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] basket = new int[Integer.parseInt(st.nextToken()) + 1];
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i < basket.length; i++) basket[i] = i;
        
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < basket.length; i++) sb.append(basket[i]).append(' ');
        System.out.println(sb);
    }
}