import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Map<String, Integer> notHear = new TreeMap<>();
        while (n-- > 0) notHear.put(br.readLine(), 0);
        int count = 0;
        while (m-- > 0) {
            String notSee = br.readLine();
            if (notHear.containsKey(notSee)) {
                count++;
                notHear.put(notSee, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (String name : notHear.keySet()) {
            if (notHear.get(name) > 0) {
                sb.append(name).append('\n');
            }
        }
        System.out.println(sb);
    }
}