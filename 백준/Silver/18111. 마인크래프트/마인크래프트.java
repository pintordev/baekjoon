import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        int n = read(), m = read(), b = read();
        int[][] land = new int[n][m];

        int min = 256, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int l = read();
                min = Math.min(min, l);
                max = Math.max(max, l);
                land[i][j] = l;
            }
        }

        int minTime = 2 * 500 * 500 * 256, maxHeight = min;
        for (int h = min; h <= max; h++) {
            int time = 0, block = b;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (land[i][j] >= h) {
                        time += 2 * (land[i][j] - h);
                        block += land[i][j] - h;
                    } else {
                        time += h - land[i][j];
                        block -= h - land[i][j];
                    }
                }
            }
            if (block < 0) continue;
            if (time <= minTime) {
                minTime = time;
                maxHeight = h;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minTime).append(' ').append(maxHeight);
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