import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] notHear = new String[n];
        for (int i = 0; i < n; i++) notHear[i] = br.readLine();
        Arrays.sort(notHear);

        String[] notSee = new String[m];
        for (int i = 0; i < m; i++) notSee[i] = br.readLine();
        Arrays.sort(notSee);

        StringBuilder sb = new StringBuilder();
        int hdx = 0, sdx = 0, count = 0;
        while (hdx < n && sdx < m) {
            if (notHear[hdx].compareTo(notSee[sdx]) < 0) hdx++;
            else if (notHear[hdx].compareTo(notSee[sdx]) > 0) sdx++;
            else {
                sb.append(notHear[hdx]).append('\n');
                hdx++;
                sdx++;
                count++;
            }
        }
        sb.insert(0, '\n').insert(0, count);
        System.out.println(sb);
    }
}