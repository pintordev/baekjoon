import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        
        Set<String> sub = new HashSet<>();
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                sub.add(s.substring(j, j + i));
            }
        }
        System.out.println(sub.size());
    }
}