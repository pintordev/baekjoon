import java.io.IOException;

public class Main {
    public static int n;
    public static long b;
    public static int[][] a;

    public static void main(String[] args) throws IOException {
        init();
        a = pow(a, b);
        print();
    }

    public static int[][] pow(int[][] a, long b) {
        if (b == 1) return a;
        if (b % 2 == 1) return mul(a, pow(a, b - 1));
        int[][] half = pow(a, b / 2);
        return mul(half, half);
    }

    public static int[][] mul(int[][] matA, int[][] matB) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    temp[i][j] += matA[i][k] * matB[k][j];
                }
                temp[i][j] %= 1000;
            }
        }
        return temp;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(a[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void init() throws IOException {
        n = read();
        b = readLong();

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = read() % 1000;
            }
        }
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    public static long readLong() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}