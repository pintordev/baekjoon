import java.io.IOException;

class Main {

    public static boolean[] visited;
    public static int[] coordinate;

    public static void main(String[] args) throws IOException {

        int n = read();

        visited = new boolean[n];
        coordinate = new int[n];

        System.out.println(put(0, n, 0));
    }

    public static int put(int cases, int n, int depth) {

        if (depth == n) return cases + 1;

        for (int j = 0; j < n; j++) {
            if (!visited[j] && isOnDiag(depth, j)) {
                visited[j] = true;
                coordinate[depth] = j;
                cases = put(cases, n, depth + 1);
                visited[j] = false;
            }
        }

        return cases;
    }

    public static boolean isOnDiag(int depth, int j) {
        for (int i = 0; i < depth; i++) {
            if (depth - i == Math.abs(j - coordinate[i])) return false;
        }
        return true;
    }

    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}