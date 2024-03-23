import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        int[][][] points = new int[2][2][2];
        for (int i = 0; i < 3; i++) {
            int[] point = {read(), read()};
            for (int j = 0; j < 2; j++) {
                if (points[j][0][0] == 0 || points[j][0][0] == point[j]) {
                    points[j][0][0] = point[j];
                    points[j][0][1]++;
                } else {
                    points[j][1][0] = point[j];
                    points[j][1][1]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(points[0][0][1] == 1 ? points[0][0][0] : points[0][1][0]).append(' ')
                .append(points[1][0][1] == 1 ? points[1][0][0] : points[1][1][0]);
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