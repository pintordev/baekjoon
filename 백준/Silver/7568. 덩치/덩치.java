import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read();
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            info[i][0] = read();
            info[i][1] = read();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int r = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) r++;
            }
            sb.append(r).append(' ');
        }
        System.out.println(sb);
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}