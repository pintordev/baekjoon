import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] names = new String[n + 1];
        int idx = 1;
        while (n-- > 0) {
            String name = br.readLine();
            map.put(name, idx);
            names[idx++] = name;
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String question = br.readLine();
            if (question.charAt(0) < 65) sb.append(names[Integer.parseInt(question)]).append('\n');
            else sb.append(map.get(question)).append('\n');
        }
        System.out.println(sb);
    }
}