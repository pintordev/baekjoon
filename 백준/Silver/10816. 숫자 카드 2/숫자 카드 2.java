import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        int[] cards = new int[20000001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) cards[Integer.parseInt(st.nextToken()) + 10000000]++;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) sb.append(cards[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
        System.out.println(sb);
    }
}