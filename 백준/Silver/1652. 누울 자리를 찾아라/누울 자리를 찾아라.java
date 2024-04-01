import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] room = new char[n][];
        for (int i = 0; i < n; i++) room[i] = br.readLine().toCharArray();

        int h = 0;
        int v = 0;
        for (int i = 0; i < n; i++) {
            int localH = 0;
            for (int j = 0; j < n; j++) {
                while (j < n && room[i][j] != 'X') {
                    localH++;
                    j++;
                }
                if (localH >= 2) h++;
                localH = 0;
            }

            int localV = 0;
            for (int j = 0; j < n; j++) {
                while (j < n && room[j][i] != 'X') {
                    localV++;
                    j++;
                }
                if (localV >= 2) v++;
                localV = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(h).append(' ').append(v);
        System.out.println(sb);
    }
}