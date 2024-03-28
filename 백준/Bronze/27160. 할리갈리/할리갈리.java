import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[4];
        StringTokenizer st;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            char name = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());
            switch (name) {
                case 'S': cards[0] += cnt; break;
                case 'B': cards[1] += cnt; break;
                case 'L': cards[2] += cnt; break;
                case 'P': cards[3] += cnt; break;
            }
        }

        boolean isMade = false;
        for (int cnt : cards) {
            if (cnt != 5) continue;
            isMade = true;
            System.out.println("YES");
            break;
        }
        if (!isMade) System.out.println("NO");
    }
}