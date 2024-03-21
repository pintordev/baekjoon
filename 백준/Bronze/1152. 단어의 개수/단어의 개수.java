import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        
        if (s.length() == 0) System.out.println(0);
        else System.out.println(s.split(" ").length);
    }
}