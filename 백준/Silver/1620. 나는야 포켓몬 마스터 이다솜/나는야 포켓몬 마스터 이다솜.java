import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameNum = new HashMap<>();
        Map<Integer, String> numName = new HashMap<>();
        int idx = 1;
        while (n-- > 0) {
            String name = br.readLine();
            nameNum.put(name, idx);
            numName.put(idx++, name);
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String question = br.readLine();
            if (question.charAt(0) < 65) sb.append(numName.get(Integer.parseInt(question))).append('\n');
            else sb.append(nameNum.get(question)).append('\n');
        }
        System.out.println(sb);
    }
}