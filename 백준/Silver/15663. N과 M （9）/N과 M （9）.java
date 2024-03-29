import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int n;
    public static int m;
    public static int[] num;
    public static int[] permutation;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        num = new int[n];
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);

        permutation = new int[m];
        visited = new boolean[n];

        permute(0);
        bw.flush();
    }

    public static void permute(int depth) throws IOException {

        if (depth == m) {
            for (int num : permutation) {
                bw.write(String.valueOf(num));
                bw.write(' ');
            }
            bw.append('\n');
            return;
        }

        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && num[i] != pre) {
                visited[i] = true;
                pre = num[i];
                permutation[depth] = num[i];
                permute(depth + 1);
                visited[i] = false;
            }
        }
    }
}