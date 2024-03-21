import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            sb.append(s.charAt(0))
                .append(s.charAt(s.length() - 1))
                .append('\n');
        }
        
        System.out.println(sb);
    }
}