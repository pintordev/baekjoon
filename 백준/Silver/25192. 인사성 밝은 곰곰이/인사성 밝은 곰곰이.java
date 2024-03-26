import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int count = 0, enter = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                enter++;
                set = new HashSet<>();
            } else if (enter > 0 && !set.contains(s)) {
                count++;
                set.add(s);
            }
        }
        System.out.println(count);
    }
}