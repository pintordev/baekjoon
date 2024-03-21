import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        double avg = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (score > max) max = score;
            avg += score;
        }

        System.out.println(avg / max * 100 / n);
    }
}