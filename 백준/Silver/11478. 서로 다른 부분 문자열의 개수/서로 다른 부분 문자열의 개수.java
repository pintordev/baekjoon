import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        
        int count = 0;
        for (int i = 1; i <= len; i++) {
            Set<String> sub = new HashSet<>();
            for (int j = 0; j <= len - i; j++) {
                sub.add(s.substring(j, j + i));
            }
            count += sub.size();
        }
        System.out.println(count);
    }
}