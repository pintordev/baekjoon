import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> relay = new HashSet<>();
        char pre = ' ', start = ' ', end = ' ';
        boolean find = false;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (!word.equals("?")) {
                relay.add(word);
                if (!find) pre = word.charAt(word.length() - 1);
                continue;
            }
            
            start = pre;
            if (i == n - 1) continue;
            
            word = br.readLine();
            relay.add(word);
            end = word.charAt(0);
            
            find = true;
            i++;
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            String word = br.readLine();
            if (relay.contains(word)) continue;
            if (start != ' ' && word.charAt(0) != start) continue;
            if (end != ' ' && word.charAt(word.length() - 1) != end) continue;
            System.out.println(word);
            break;
        }
    }
}