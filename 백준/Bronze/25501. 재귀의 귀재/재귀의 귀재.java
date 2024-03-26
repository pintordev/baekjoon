import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] c = br.readLine().toCharArray();
            int[] rs = isPD(c, 0, c.length - 1, 1);
            sb.append(rs[0]).append(' ')
                    .append(rs[1]).append('\n');
        }
        System.out.println(sb);
    }

    public static int[] isPD(char[] c, int l, int r, int count) {
        if (l >= r) return new int[]{1, count};
        if (c[l] != c[r]) return new int[]{0, count};
        return isPD(c, l + 1, r - 1, count + 1);
    }
}