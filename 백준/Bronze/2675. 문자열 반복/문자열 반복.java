import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            char[] c = st.nextToken().toCharArray();
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < r; j++) sb.append(c[i]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}