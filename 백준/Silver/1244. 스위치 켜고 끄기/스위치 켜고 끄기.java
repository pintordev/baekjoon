import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static int n;
    public static int[] toggle;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        toggle = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) toggle[i] = Integer.parseInt(input[i]);

        int i = Integer.parseInt(br.readLine());
        while (i-- > 0) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[1]);
            if (input[0].equals("1")) male(x);
            else female(x);
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < n; i++) {
            sb.append(toggle[i]).append(' ');
            if ((i + 1) % 20 == 0) sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void male(int x) {
        int i = x - 1;
        while (i < n) {
            if (toggle[i] == 0) toggle[i] = 1;
            else toggle[i] = 0;
            i += x;
        }
    }

    public static void female(int x) {
        int i = x - 1, di = 0;
        while (i - di >= 0 && i + di < n) {
            if (toggle[i - di] != toggle[i + di]) break;
            int on = toggle[i - di];
            if (on == 0) {
                toggle[i - di] = 1;
                toggle[i + di] = 1;
            } else {
                toggle[i - di] = 0;
                toggle[i + di] = 0;
            }
            di++;
        }
    }
}