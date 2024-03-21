import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0, idx = 0;
        for (int i = 1; i <= 9; i++) {
            int n = Integer.parseInt(br.readLine());
            if (max < n) {
                max = n;
                idx = i;
            }
        }
        
        System.out.printf("%d\n%d", max, idx);
    }
}