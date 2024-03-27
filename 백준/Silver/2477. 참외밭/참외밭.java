import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            if (dir[i] != dir[(i + 2) % 6]) continue;
            if (dir[(i + 1) % 6] != dir[(i + 3) % 6]) continue;
            System.out.println((len[(i + 4) % 6] * len[(i + 5) % 6]
                               - len[(i + 1) % 6] * len[(i + 2) % 6]) 
                               * k);
            break;
        }

    }
}