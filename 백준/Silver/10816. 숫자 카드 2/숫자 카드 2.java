import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        int[] map = new int[20000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            int i = Integer.parseInt(st.nextToken());
            map[i + 10000000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int i = Integer.parseInt(st.nextToken());
            sb.append(map[i + 10000000]).append(' ');
        }
        System.out.println(sb);
    }
}