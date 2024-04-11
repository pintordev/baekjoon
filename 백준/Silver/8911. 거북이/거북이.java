import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int minX = 0, maxX = 0, minY = 0, maxY = 0;
            int x = 0, y = 0, d = 0, cLen = commands.length;
            for (int i = 0; i < cLen; i++) {
                if (commands[i] == 'F') {
                    x += dx[d];
                    y += dy[d];
                } else if (commands[i] == 'B') {
                    x -= dx[d];
                    y -= dy[d];
                } else if (commands[i] == 'L') {
                    d = (d + 3) % 4;
                } else {
                    d = (d + 1) % 4;
                }
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            sb.append((maxX - minX) * (maxY - minY)).append('\n');
        }
        System.out.println(sb);
    }
}