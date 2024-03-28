import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> inOffice = new TreeSet<>(Comparator.reverseOrder());
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.nextToken().equals("enter")) inOffice.add(name);
            else inOffice.remove(name);
        }

        StringBuilder sb = new StringBuilder();
        for (String name : inOffice) sb.append(name).append('\n');
        System.out.println(sb);
    }
}