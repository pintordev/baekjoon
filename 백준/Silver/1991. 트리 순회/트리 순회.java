import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();
        
        while (n-- > 0) {
            char[] nodes = br.readLine().toCharArray();
            
            String preStr = nodesToStr(nodes[0], nodes[2], nodes[4]);
            String inStr = nodesToStr(nodes[2], nodes[0], nodes[4]);
            String postStr = nodesToStr(nodes[2], nodes[4], nodes[0]);
            
            add(pre, preStr, nodes[0]);
            add(in, inStr, nodes[0]);
            add(post, postStr, nodes[0]);
        }
        
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    
    public static String nodesToStr(char c1, char c2, char c3) {
        StringBuilder sb = new StringBuilder();
        if (c1 != '.') sb.append(c1);
        if (c2 != '.') sb.append(c2);
        if (c3 != '.') sb.append(c3);
        return sb.toString();
    }
    
    public static void add(StringBuilder sb, String s, char c) {
        int i = sb.indexOf(c + "");
        if (i == -1) sb.append(s);
        else {
            sb.deleteCharAt(i);
            sb.insert(i, s);
        }
    }
    
}