import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            files.put(ext, files.getOrDefault(ext, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String ext : files.keySet()) sb.append(ext).append(' ').append(files.get(ext)).append('\n');
        System.out.println(sb);
    }
}