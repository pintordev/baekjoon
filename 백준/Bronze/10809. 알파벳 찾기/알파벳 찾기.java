import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        int[] idx = new int[26];
        for (int i = 0; i < c.length; i++) {
            int j = c[i] - 97;
            if (idx[j]  == 0) idx[j] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) sb.append(idx[i] - 1).append(' ');
        System.out.println(sb);
    }
}