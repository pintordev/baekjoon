import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> files = new TreeMap<>();
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String ext = st.nextToken();
            Integer cnt = files.putIfAbsent(ext, 1);
            if (cnt != null) files.put(ext, cnt + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String ext : files.keySet()) sb.append(ext).append(' ').append(files.get(ext)).append('\n');
        System.out.println(sb);
    }
}