import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> inRoom = new HashSet<>();
        int count = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) inRoom = new HashSet<>();
            else if (inRoom.add(s)) count++;
        }
        System.out.println(count);
    }
}