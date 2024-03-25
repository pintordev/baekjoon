import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean io = st.nextToken().equals("enter");
            if (io) set.add(name);
            else set.remove(name);
        }

        StringBuilder sb = new StringBuilder();
        for (String name : set) sb.append(name).append('\n');
        System.out.println(sb);
    }
}