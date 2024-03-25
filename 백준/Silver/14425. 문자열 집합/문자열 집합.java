import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        while (n-- > 0) set.add(br.readLine());

        int count = 0;
        while (m-- > 0) {
            if (set.contains(br.readLine())) count++;
        }
        System.out.println(count);
    }
}