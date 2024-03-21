import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> remains = new HashSet<>();
        
        for (int i = 0; i < 10; i++) {
            remains.add(Integer.parseInt(br.readLine()) % 42);
        }
        
        System.out.println(remains.size());
    }
}