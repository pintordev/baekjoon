import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Set<String> notHear = new HashSet<>();
        while (n-- > 0) notHear.add(br.readLine());

        Set<String> notHearAndSee = new TreeSet<>();
        while (m-- > 0) {
            String notSee = br.readLine();
            if (!notHear.add(notSee)) notHearAndSee.add(notSee);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(notHearAndSee.size()).append('\n');
        for (String name : notHearAndSee) sb.append(name).append('\n');
        System.out.println(sb);
    }
}