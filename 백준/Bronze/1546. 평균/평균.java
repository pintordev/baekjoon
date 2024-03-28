import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());
            sum += m;
            max = Math.max(max, m);
        }
        System.out.println((double) sum / max * 100 / n);
    }
}