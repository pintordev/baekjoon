import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] basket = new int[Integer.parseInt(st.nextToken()) + 1];
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i < basket.length; i++) basket[i] = i;
        
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int[] copy = Arrays.copyOfRange(basket, i, j + 1);
            for (; i <= j; i++) basket[i] = copy[j - i];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < basket.length; i++) sb.append(basket[i]).append(' ');
        System.out.println(sb);
    }
}